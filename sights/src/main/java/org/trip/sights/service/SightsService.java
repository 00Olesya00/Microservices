package org.trip.sights.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.trip.sights.entity.Sights;
import org.trip.sights.entity.SightsDto;
import org.trip.sights.repository.CategoryRepository;
import org.trip.sights.repository.SightsRepository;

@Slf4j
@Service
public class SightsService {

    @Autowired
    SightsRepository sightsRepository;
    @Autowired
    CategoryRepository categoryRepository;

    public String addPlace(SightsDto sightsDto) {
        log.info(sightsDto.toString());
        Sights sights = new Sights();
        sights = sightsDto.toEntity();
        sights.setCategory(categoryRepository.findByName(sightsDto.getCategory()));
        sightsRepository.save(sights);
        return "sight added";
    }

    public String deletePlace(String name) {

        sightsRepository.deleteByName(name);
        return "sight deleted";}
}
