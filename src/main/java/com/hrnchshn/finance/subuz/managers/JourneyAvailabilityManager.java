package com.hrnchshn.finance.subuz.managers;

import com.hrnchshn.finance.subuz.dao.JourneySubscriptionDao;
import com.hrnchshn.finance.subuz.entity.JourneySubscription;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@Component
@RequiredArgsConstructor
public class JourneyAvailabilityManager {

    private final JourneySubscriptionDao journeySubscriptionDao;

    public void checkJourneySubscriptionsAvailability(){
//        List<JourneySubscription> subscriptions = journeySubscriptionDao.findAll();
//        subscriptions.forEach(subscricption -> );
        callUzGov(null);
    }


    private String callUzGov(JourneySubscription subscription) {
        try {
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost("https://booking.uz.gov.ua/train_search/");
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("from", "2208001"));
            nvps.add(new BasicNameValuePair("to", "2218000"));
            nvps.add(new BasicNameValuePair("date", "2019-04-11"));
            nvps.add(new BasicNameValuePair("time", "02:00"));

            post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));

            HttpResponse response = httpClient.execute(post);

            BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
            String line = null;
            while((line = in.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {

        }
        return null;


    }
}
