package org.trip.sights.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.trip.sights.service.SightsService;

@RestController
@Slf4j
public class SightsController {
    @Autowired
    SightsService sightsService;

}
