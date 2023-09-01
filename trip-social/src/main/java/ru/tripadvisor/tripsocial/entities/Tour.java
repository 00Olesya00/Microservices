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
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "about")
    private String about;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    //    Точка отправления (адрес)
    @Column(name = "departure_location")
    private String departureLocation;

    //    Точка назначения (адрес)
    @Column(name = "destination_location")
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


}


