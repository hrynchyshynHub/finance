package com.hrnchshn.finance.subuz.managers;

import com.hrnchshn.finance.subuz.entity.JourneySubscription;
import com.hrnchshn.finance.subuz.entity.StationDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/**
 * @author ivan.hrynchyshyn
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class UzGovResponseParser {

    private final EmailSenderManager emailSenderManager;
    private static final String SIT_NOT_FOUND = "По заданому Вами напрямку місць немає";
    private static final String TRAIN_NOT_FOUND = "По заданому Вами напрямку немає маршуту";

    public void parse(JourneySubscription subscription, String response){
        log.info("Parsing response : " + response);
        JSONObject json = new JSONObject(response);
        JSONObject data = json.getJSONObject("data");
        if(data.has("warning")) {
            String warning = data.getString("warning");
            subscription.setWarningMessage(warning);
            if(warning.equals(SIT_NOT_FOUND)) return;
        }

        if(data.has("list") && data.getJSONArray("list").isEmpty()){
                String warning = TRAIN_NOT_FOUND;
                subscription.setWarningMessage(warning);
        }

        if(!data.has("warning") && !data.getJSONArray("list").isEmpty()){
            JSONArray trainsList = data.getJSONArray("list");
            for(int index = 0; index <= trainsList.length() - 1; index++){
                JSONObject train = trainsList.getJSONObject(index);
                if(train.has("types")){
                    JSONArray types = train.getJSONArray("types");
                    if(!types.isEmpty()){
                        emailSenderManager.sendEmail(
                                subscription.getUser().getEmail(),
                                types.toString(),
                                "Available train found");
                        subscription.setActive(false);
                        log.info("Mail has been sent");
                    }
                }
            }

        }
    }

    public List<StationDTO> parseStationResponse(String response){
        List<StationDTO> stations = new ArrayList<>();
        JSONArray json = new JSONArray(response);
        if(!json.isEmpty()){
            for(int i = 0 ; i <= json.length() - 1; i++){
                JSONObject station = json.getJSONObject(i);
                StationDTO stationDTO = StationDTO.builder()
                        .title((station.has("title") ? station.getString("title") : ""))
                        .value((station.has("value") ? station.getLong("value") : null))
                        .build();
                stations.add(stationDTO);
            }
        }
        return stations;
    }
}
