package com.hrnchshn.finance.utils;

public class WebCallResponse {

    private int httpStatusCode;
    private String httpResponseBody;

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getHttpResponseBody() {
        return httpResponseBody;
    }

    public void setHttpResponseBody(String httpResponseBody) {
        this.httpResponseBody = httpResponseBody;
    }

    @Override
    public String toString() {
        return "WebCallResponse{" + "httpStatusCode=" + httpStatusCode + ", httpResponseBody=" + httpResponseBody + '}';
    }

}