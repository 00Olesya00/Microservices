package ru.tripadvisor.tripsocial.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "sights")
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    private String name;
    private String location;
//    private String coordinates;
    private String description; //описание
    private Double price;
    private String price_info;
    private String url;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "sight_category_id")
    private SightCategory sightCategory;

    public Sight(String name, String location, String description, Double price, String price_info, String url, Tour tour, SightCategory sightCategory) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.price = price;
        this.price_info = price_info;
        this.url = url;
        this.tour = tour;
        this.sightCategory = sightCategory;
    }


    public Sight() {

    }
}


