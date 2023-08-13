package ru.tripadvisor.tripsocial.entities;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;


@Entity
@Data
@Table(name = "tours")
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String about;
    private Date startDate;
    private Date endDate;

    //    Точка отправления (адрес)
    private String departureLocation;

    //    Точка назначения (адрес)
    private String destinationLocation;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "tour_type_id")
    private TourType tourType;

    @ManyToOne
    @JoinColumn(name = "status_id")
    private Status status;



    public Tour(String name, String about) {
        this.name = name;
        this.about = about;
    }

    public Tour() {
    }

    public Tour( String name, String about, Date startDate, Date endDate, String departureLocation, String destinationLocation) {

        this.name = name;
        this.about = about;
        this.startDate = startDate;
        this.endDate = endDate;
        this.departureLocation = departureLocation;
        this.destinationLocation = destinationLocation;

    }





}


