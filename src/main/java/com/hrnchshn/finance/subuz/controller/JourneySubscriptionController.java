package com.hrnchshn.finance.subuz.controller;


import com.hrnchshn.finance.constants.Api;
import com.hrnchshn.finance.subuz.entity.JourneySubscriptionDto;
import com.hrnchshn.finance.subuz.entity.StationDTO;
import com.hrnchshn.finance.subuz.managers.StationFinderManager;
import com.hrnchshn.finance.subuz.service.JourneySubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ivan.hrynchyshyn
 */
@RestController
@RequestMapping(Api.JOURNEY)
@RequiredArgsConstructor
public class JourneySubscriptionController {

    private final JourneySubscriptionService subscriptionService;
    private final StationFinderManager stationFinderManager;

    @GetMapping
    public List<JourneySubscriptionDto> getAll(){
        return subscriptionService.getAll();
    }

    @GetMapping("/{id}")
    public JourneySubscriptionDto getSubscription(@PathVariable("id") Long id){
        return subscriptionService.getOne(id);
    }


    @GetMapping("/search")
    public List<StationDTO> getStations(@RequestParam("term") String term){
        return stationFinderManager.findStationByTerm(term);
    }

    @PostMapping
    public JourneySubscriptionDto createSubscription(@RequestBody JourneySubscriptionDto subscriptionDto){
        return subscriptionService.save(subscriptionDto);
    }

    @PutMapping("/{id}")
    public void updateJourney(@PathVariable("id") Long id,
                             @RequestBody JourneySubscriptionDto subscriptionDto){
        subscriptionService.update(id, subscriptionDto);
    }

    @DeleteMapping("/{id}")
    public void deleteJourney(@PathVariable("id") Long id){
        subscriptionService.deleteSubscription(id);
    }
}
