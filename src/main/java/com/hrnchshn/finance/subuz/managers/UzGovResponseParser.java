package com.hrnchshn.finance.subuz.managers;

import com.hrnchshn.finance.subuz.entity.JourneySubscription;
import com.hrnchshn.finance.subuz.entity.SitPlace;
import com.hrnchshn.finance.subuz.entity.StationDTO;
import com.hrnchshn.finance.subuz.entity.Train;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


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

        if (!data.has("warning") && !data.getJSONArray("list").isEmpty()) {
            JSONArray trainsList = data.getJSONArray("list");

            List<Train> trains = toTrainEntity(trainsList);

            List<Train> availablePlacesTrains = trains.stream()
                    .filter(train -> !train.getPlaces().isEmpty())
                    .collect(Collectors.toList());

            if(!availablePlacesTrains.isEmpty()){
                emailSenderManager.sendEmail(
                        subscription.getUser().getEmail(),
                        availablePlacesTrains,
                        "Available train found");
//                subscription.setActive(false);
                log.info("Mail has been sent");
            }
        }
    }





    private List<Train> toTrainEntity(JSONArray trainsList) {
        List<Train> trains = new ArrayList<>();
        for (int index = 0; index <= trainsList.length() - 1; index++) {
            JSONObject train = trainsList.getJSONObject(index);
            JSONArray places = train.getJSONArray("types");
            List<SitPlace> sitPlaces = new ArrayList<>();
            if (!places.isEmpty()) {
                for(int j = 0; j <= places.length() - 1; j++){
                    JSONObject place = places.getJSONObject(j);
                    sitPlaces.add(SitPlace.builder()
                            .type(place.getString("title"))
                            .count(place.getInt("places"))
                            .build());
                }
            }
            trains.add(Train.builder()
                    .trainNumber(train.getString("num"))
                    .arrivalDateTime(train.getJSONObject("from").getString("date") + " " + train.getJSONObject("from").getString("time"))
                    .departingDateTime(train.getJSONObject("to").getString("date") + " " + train.getJSONObject("to").getString("time"))
                    .fromStation(train.getJSONObject("from").getString("station"))
                    .toStation(train.getJSONObject("to").getString("station"))
                    .places(sitPlaces)
                    .build());
        }
        return trains;
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
