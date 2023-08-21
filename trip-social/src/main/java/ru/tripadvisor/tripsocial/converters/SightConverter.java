package ru.tripadvisor.tripsocial.converters;

import org.springframework.stereotype.Component;
import ru.tripadvisor.tripsocial.dto.SightDto;
import ru.tripadvisor.tripsocial.entities.Sight;
import ru.tripadvisor.tripsocial.entities.SightCategory;
import ru.tripadvisor.tripsocial.entities.Tour;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Component
public class SightConverter {

    public Sight dtoToEntity(SightDto sightDto){
        return new Sight(sightDto.getName(),
                sightDto.getLocation(),
                sightDto.getDescription(),
                sightDto.getPrice(),
                sightDto.getPrice_info(),
                sightDto.getUrl(),
                sightDto.getTour(),
                sightDto.getSightCategory());
    }

    public SightDto entityToDto(Sight sight){
        return new SightDto(sight.getId(),
                sight.getName(),
                sight.getLocation(),
                sight.getDescription(),
                sight.getPrice(),
                sight.getPrice_info(),
                sight.getUrl(),
                sight.getTour(),
                sight.getSightCategory());
    }
}

