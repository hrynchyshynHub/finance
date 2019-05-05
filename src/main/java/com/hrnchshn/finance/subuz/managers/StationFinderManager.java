package com.hrnchshn.finance.subuz.managers;

import com.hrnchshn.finance.constants.Api;
import com.hrnchshn.finance.subuz.entity.StationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@RequiredArgsConstructor
@Component
@Slf4j
public class StationFinderManager {

    private final UzGovResponseParser parser;

    public List<StationDTO> findStationByTerm(String term) {
        List<StationDTO> stationDTOS = new ArrayList<>();
        try {
            HttpClient httpClient = HttpClients.createDefault();
            String template = "station/?term=%s";
            HttpGet get = new HttpGet(Api.UZ_GOV + String.format(template, term));
            HttpResponse response = httpClient.execute(get);
            HttpEntity entity = response.getEntity();
            stationDTOS = parser.parseStationResponse(EntityUtils.toString(entity, StandardCharsets.UTF_8));
        } catch (IOException e) {
            log.error("Can`t find stations. Message: ", e);
        }
        return stationDTOS;
    }

}
