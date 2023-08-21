package ru.tripadvisor.tripsocial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tripadvisor.tripsocial.entities.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.sql.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourDto {

    private Long id;
    private String name;
    private String about;
   private Date startDate;
    private Date endDate;
    //    Точка отправления (адрес)
    private String departureLocation;
    //    Точка назначения (адрес)
    private String destinationLocation;
    private User user;
    private TourType tourType;
    private Status status;

    private List<Sight> sights;
    private List<Comfort> comforts;
    private List<Catering> caterings;

    public TourDto(Tour tour) {
        this.id = tour.getId();
        this.name = tour.getName();
        this.about = tour.getAbout();
        this.startDate = tour.getStartDate();
        this.endDate = tour.getEndDate();
        this.departureLocation = tour.getDepartureLocation();
        this.destinationLocation = tour.getDestinationLocation();
        this.user = tour.getUser();
        this.tourType = tour.getTourType();
        this.status = tour.getStatus();
        this.sights = tour.getSights();
        this.comforts = tour.getComforts();
        this.caterings = tour.getCaterings();
    }

}
