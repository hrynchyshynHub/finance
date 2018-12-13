package com.hrnchshn.finance.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


/**
 *
 * @author ihr
 */
public class WebCall {

    public WebCall(HttpVerb httpVerb, String url) {
        this.httpVerb = httpVerb;
        this.url = url;
    }

    public enum HttpVerb {
        POST, GET, PUT, PATCH, DELETE
    }

    public enum PayloadType {
        text, json, pdf
    }

    private HttpVerb httpVerb;
    private String url;
    private PayloadType payloadType;
    private Object payload;

    private Map<String, String> headers = new HashMap<>();

    public void setHttpVerb(HttpVerb httpVerb) {
        this.httpVerb = httpVerb;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setPayloadType(PayloadType payloadType) {
        this.payloadType = payloadType;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public void setHeader(String key, String value) {
        headers.put(key, value);
    }

    @Override
    public String toString() {
        return "WebCall{" + "httpVerb=" + httpVerb + ", url=" + url + ", payloadType=" + payloadType + ", payload=" + payload;
    }

    private String getContentType() {
        switch (payloadType) {
            case json:
                return "application/json; charset=utf-8";
            case pdf:
                return "application/pdf";
            case text:
            default:
                return "text/plain; charset=utf-8";
        }
    }

    public WebCallResponse execute() throws Exception {

        WebCallResponse response = new WebCallResponse();

        URL url_ = new URL(url);

        HttpURLConnection urlConnection = (HttpURLConnection) url_.openConnection();
        urlConnection.setDoOutput(true);
        urlConnection.setDoInput(true);
        urlConnection.setRequestMethod(httpVerb.name());
        urlConnection.setConnectTimeout(15000);
        urlConnection.setReadTimeout(15000);

        for (Map.Entry<String, String> header : headers.entrySet()) {
            urlConnection.setRequestProperty(header.getKey(), header.getValue());
        }

        if (httpVerb != HttpVerb.GET && httpVerb != HttpVerb.DELETE) {
            urlConnection.setRequestProperty("Content-Type", getContentType());

            switch (payloadType) {
                case pdf:
                    ByteArrayOutputStream bos = new ByteArrayOutputStream();
                    bos.write((byte[]) payload);
                    bos.writeTo(urlConnection.getOutputStream());
                    bos.flush();
                    bos.close();
                    break;
                default:
                    try (BufferedWriter out = new BufferedWriter(new OutputStreamWriter(urlConnection.getOutputStream(), "UTF-8"))) {
                        out.write((String) payload);
                        out.flush();
                    }
                    break;
            }
        }

        Reader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "UTF-8"));
        } catch (Exception ex) {
//            log.debug("Could not read success response: " + ex);
            try {
                reader = new BufferedReader(new InputStreamReader(urlConnection.getErrorStream(), "UTF-8"));
            } catch (Exception exx) {
//                log.debug("Could not read error response: " + exx);
            }
        } finally {
            String responseBody = null;
            if (reader != null) {
                char[] arr = new char[8 * 1024];
                StringBuilder buffer = new StringBuilder();
                int numCharsRead;
                while ((numCharsRead = reader.read(arr, 0, arr.length)) != -1) {
                    buffer.append(arr, 0, numCharsRead);
                }
                reader.close();
                responseBody = buffer.toString();
                response.setHttpResponseBody(responseBody);
                reader.close();
            }
        }

        response.setHttpStatusCode(urlConnection.getResponseCode());
        return response;
    }

}

