package ru.tripadvisor.tripsocial.entities;

import lombok.Data;
import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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

    @OneToMany(mappedBy = "tour")
    private List<Catering> caterings;

    @OneToMany(mappedBy = "tour")
    private List<Comfort> comforts;

    @OneToMany(mappedBy = "tour")
    private List<Sight> sights;

    public Tour() {
    }
//
//    public Tour( String name, String about, Date startDate, Date endDate, String departureLocation, String destinationLocation) {
//        this.name = name;
//        this.about = about;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.departureLocation = departureLocation;
//        this.destinationLocation = destinationLocation;
//
//    }


    public Tour(String name, String about, Date startDate, Date endDate, String departureLocation, String destinationLocation, User user, TourType tourType, Status status, List<Sight> sights, List<Comfort> comforts, List<Catering> caterings) {
        this.name = name;
        this.about = about;
        this.startDate = startDate;
        this.endDate = endDate;
        this.departureLocation = departureLocation;
        this.destinationLocation = destinationLocation;
        this.user = user;
        this.tourType = tourType;
        this.status = status;
        this.sights = sights;
        this.comforts = comforts;
        this.caterings = caterings;
    }



    //
//    public Tour(Long id, String name, String about, Date startDate, Date endDate, String departureLocation, String destinationLocation) {
//        this.id = id;
//        this.name = name;
//        this.about = about;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.departureLocation = departureLocation;
//        this.destinationLocation = destinationLocation;
//
//    }


}


