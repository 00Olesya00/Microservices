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
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description; //описание

    @Column(name = "visit_date")
    private Date visitDate;

    @Column(name = "rating")
    private Integer rating;

    @Column(name = "price")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "tour_id")
    private Tour tour;


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


