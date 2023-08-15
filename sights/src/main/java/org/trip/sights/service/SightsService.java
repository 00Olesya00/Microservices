package org.trip.sights.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trip.sights.repository.SightsRepository;

@Slf4j
@Service
public class SightsService {

    @Autowired
    SightsRepository sightsRepository;

}
