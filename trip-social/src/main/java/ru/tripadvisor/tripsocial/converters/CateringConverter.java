package ru.tripadvisor.tripsocial.converters;

import org.springframework.stereotype.Component;
import ru.tripadvisor.tripsocial.dto.CateringDto;
import ru.tripadvisor.tripsocial.entities.Catering;

@Component
public class CateringConverter {

    public Catering dtoToEntity(CateringDto cateringDto){
        return new Catering(cateringDto.getName(),
                cateringDto.getDescription(),
                cateringDto.getVisitDate(),
                cateringDto.getRating(),
                cateringDto.getPrice(),
                cateringDto.getTour());
    }

    public CateringDto entityToDto(Catering catering){
        return new CateringDto(catering.getId(),
                catering.getName(),
                catering.getDescription(),
                catering.getVisitDate(),
                catering.getRating(),
                catering.getPrice(),
                catering.getTour());
    }
}
