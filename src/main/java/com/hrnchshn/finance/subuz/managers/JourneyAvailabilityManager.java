package com.hrnchshn.finance.subuz.managers;

import com.hrnchshn.finance.constants.Api;
import com.hrnchshn.finance.subuz.dao.JourneySubscriptionDao;
import com.hrnchshn.finance.subuz.entity.JourneySubscription;
import com.hrnchshn.finance.subuz.entity.JourneySubscriptionDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


/**
 * @author ivan.hrynchyshyn
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class JourneyAvailabilityManager {

    private final JourneySubscriptionDao journeySubscriptionDao;

    private final UzGovResponseParser responseParser;

    public void checkJourneySubscriptionsAvailability() {
        List<JourneySubscription> subscriptions = journeySubscriptionDao.findByIsActiveTrue();
        subscriptions.forEach(this::callUzGov);
    }


    private void callUzGov(JourneySubscription subscription) {
        try {
            subscription.incrementCallAttempt();
            HttpClient httpClient = HttpClients.createDefault();
            HttpPost post = new HttpPost(Api.UZ_GOV);
            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("from", String.valueOf(subscription.getSrcPlace())));
            nvps.add(new BasicNameValuePair("to", String.valueOf(subscription.getDestPlace())));
            nvps.add(new BasicNameValuePair("date", String.valueOf(subscription.getDate())));
            nvps.add(new BasicNameValuePair("time", String.valueOf(subscription.getTime())));

            post.setEntity(new UrlEncodedFormEntity(nvps));
            HttpResponse response = httpClient.execute(post);
            HttpEntity entity = response.getEntity();
            String json = EntityUtils.toString(entity, StandardCharsets.UTF_8);
            responseParser.parse(subscription, json);
            journeySubscriptionDao.save(subscription);
        } catch (Exception e) {
            log.error("Can`t call uzgov.service",  e);
        }
    }
}
