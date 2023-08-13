package ru.tripadvisor.tripsocial.entities;
import lombok.Data;
import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@Table(name = "caterings")
public class Catering {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description; //описание
    private Date visitDate;
    private Integer rating;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;


//    public Catering(String name, String description, Date visitDate, Integer rating, Double price) {
//        this.name = name;
//        this.description = description;
//        this.visitDate = visitDate;
//        this.rating = rating;
//        this.price = price;
//
//    }

    public Catering(String name, String description, Date visitDate, Integer rating, Double price, Tour tour) {
        this.name = name;
        this.description = description;
        this.visitDate = visitDate;
        this.rating = rating;
        this.price = price;
        this.tour = tour;
    }

    public Catering() {

    }
}


