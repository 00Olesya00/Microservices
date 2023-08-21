package ru.tripadvisor.tripsocial.converters;

import org.springframework.stereotype.Component;
import ru.tripadvisor.tripsocial.dto.TourDto;
import ru.tripadvisor.tripsocial.entities.*;

import java.util.List;

@Component
public class TourConverter {

    private User user;
    private TourType tourType;
    private Status status;
    private List<Sight> sights;
    private List<Comfort> comforts;
    private List<Catering> caterings;

    //дто записываем в сущность
    public Tour dtoToEntity(TourDto tourDto){
        return new Tour(tourDto.getName(),
                tourDto.getAbout(),
                tourDto.getStartDate(),
                tourDto.getEndDate(),
                tourDto.getDepartureLocation(),
                tourDto.getDestinationLocation(),
                tourDto.getUser(),
                tourDto.getTourType(),
                tourDto.getStatus(),
                tourDto.getSights(),
                tourDto.getComforts(),
                tourDto.getCaterings());
    }

    // сущность перегоняем в дто
    public TourDto entityToDto(Tour tour){
        return new TourDto(tour.getId(),
                tour.getName(),
                tour.getAbout(),
                tour.getStartDate(),
                tour.getEndDate(),
                tour.getDepartureLocation(),
                tour.getDestinationLocation(),
                tour.getUser(),
                tour.getTourType(),
                tour.getStatus(),
                tour.getSights(),
                tour.getComforts(),
                tour.getCaterings());
    }
}
