package ru.tripadvisor.tripsocial.entities;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
@Table(name = "comforts")
public class Comfort {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "price_info")
    private String price_info;

    @Column(name = "info")
    private String info;

    @Column(name = "url")
    private String url;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;

    public Comfort() {

    }

    public Comfort(String name, Double price, String price_info, String info, String url, Tour tour) {
        this.name = name;
        this.price = price;
        this.price_info = price_info;
        this.info = info;
        this.url = url;
        this.tour = tour;
    }
}


