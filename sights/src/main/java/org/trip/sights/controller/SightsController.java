package org.trip.sights.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.trip.sights.entity.SightsDto;
import org.trip.sights.service.SightsService;

@RestController
@Slf4j
public class SightsController {
    @Autowired
    SightsService sightsService;

    @PostMapping("/addPlace")
    public String addPlace(@RequestBody SightsDto sightsDto) {
        log.info(sightsDto.toString());
        return sightsService.addPlace(sightsDto);

    }

    @PostMapping("/deletePlace")
    public String deletePlace(@RequestBody String name) {
        log.info(name);
        return sightsService.deletePlace(name);

    }


}
