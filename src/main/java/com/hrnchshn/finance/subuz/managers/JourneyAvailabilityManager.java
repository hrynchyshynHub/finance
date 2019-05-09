package com.hrnchshn.finance.subuz.managers;

import com.hrnchshn.finance.auser.AUser;
import com.hrnchshn.finance.constants.Api;
import com.hrnchshn.finance.subuz.dao.JourneySubscriptionDao;
import com.hrnchshn.finance.subuz.entity.JourneySubscription;
import com.hrnchshn.finance.subuz.entity.Train;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
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
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;


/**
 * @author ivan.hrynchyshyn
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class JourneyAvailabilityManager implements Processor {

    private final JourneySubscriptionDao journeySubscriptionDao;
    private final UzGovResponseParser responseParser;
    private final Map<AUser, List<Train>> map = new ConcurrentHashMap<>();

    @Override
    public void process(Exchange exchange) {
        journeySubscriptionDao.findByIsActiveTrue().forEach(subscription -> {
            List<Train> availableForThisUser = callUzGov(subscription);
            List<Train> trains = Optional.ofNullable(map.get(subscription.getUser()))
                    .orElse(new ArrayList<>());
            trains.addAll(availableForThisUser);
            map.put(subscription.getUser(), trains);
        });
        Message message = exchange.getIn();
        message.setBody(new HashMap<>(map), Map.class);
        map.clear();
    }


    private List<Train> callUzGov(JourneySubscription subscription) {
        List<Train> availableTrains = new ArrayList<>();
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
            availableTrains = responseParser.parseAndGetAvailableTrains(subscription, json);
            journeySubscriptionDao.save(subscription);
        } catch (Exception e) {
            log.error("Can`t call uzgov.service",  e);
        }
        return availableTrains;
    }
}
