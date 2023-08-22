package org.trip.sights.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trip.sights.entity.Sights;
import org.trip.sights.entity.SightsDto;
import org.trip.sights.repository.SightsRepository;

@Slf4j
@Service
public class SightsService {

    @Autowired
    SightsRepository sightsRepository;

    public String addPlace(SightsDto sightsDto) {
        Sights sights = sightsDto.toEntity();
        sightsRepository.save(sights);
        return "sights added";
    }
}
