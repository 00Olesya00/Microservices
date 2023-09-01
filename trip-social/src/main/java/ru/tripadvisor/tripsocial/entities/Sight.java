package ru.tripadvisor.tripsocial.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "sights")
public class Sight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

      @Column(name = "description")
    private String description; //описание

    @Column(name = "price")
    private Double price;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "price_info")
    private String price_info;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    @ManyToOne
    @JoinColumn(name = "sight_category_id")
    private SightCategory sightCategory;

    public Sight(String name, String location, String description, Double price, String coordinates, String price_info, String url, Tour tour, SightCategory sightCategory) {
        this.name = name;
        this.location = location;
        this.description = description;
        this.price = price;
        this.coordinates =coordinates;
        this.price_info = price_info;
        this.url = url;
        this.tour = tour;
        this.sightCategory = sightCategory;
    }


    public Sight() {

    }
}


