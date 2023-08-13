package ru.tripadvisor.tripsocial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tripadvisor.tripsocial.entities.Catering;
import ru.tripadvisor.tripsocial.entities.Tour;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CateringDto {

    private Long id;
    private String name;
    private String description; //описание
    private Date visitDate;
    private Integer rating;
    private Double price;

    private Tour tour;

    public CateringDto(Catering catering) {
        this.id = catering.getId();
        this.name = catering.getName();
        this.description =catering.getDescription();
        this.visitDate = catering.getVisitDate();
        this.rating = catering.getRating();
        this.price = catering.getPrice();
        this.tour=catering.getTour();
    }


}
