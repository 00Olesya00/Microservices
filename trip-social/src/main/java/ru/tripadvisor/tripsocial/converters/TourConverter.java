package ru.tripadvisor.tripsocial.converters;

import org.springframework.stereotype.Component;
import ru.tripadvisor.tripsocial.dto.TourDto;
import ru.tripadvisor.tripsocial.entities.Tour;

@Component
public class TourConverter {

    //дто записываем в сущность
    public Tour dtoToEntity(TourDto tourDto){
        return new Tour(tourDto.getName(),tourDto.getAbout(),tourDto.getStartDate(),tourDto.getEndDate(),tourDto.getDepartureLocation(),tourDto.getDestinationLocation());
    }

    // сущность перегоняем в дто
    public TourDto entityToDto(Tour tour){
        return new TourDto(tour.getId(),tour.getName(),tour.getAbout(),tour.getStartDate(),tour.getEndDate(),tour.getDepartureLocation(),tour.getDestinationLocation());
    }
}
