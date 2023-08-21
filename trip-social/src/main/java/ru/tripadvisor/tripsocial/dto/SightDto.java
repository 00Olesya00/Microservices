package ru.tripadvisor.tripsocial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tripadvisor.tripsocial.entities.Sight;
import ru.tripadvisor.tripsocial.entities.SightCategory;
import ru.tripadvisor.tripsocial.entities.Tour;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SightDto {

    private Long id;
    private String name;
    private String location;
    //    private String coordinates;
    private String description; //описание
    private Double price;
    private String price_info;
    private String url;
    private Tour tour;
    private SightCategory sightCategory;


    public SightDto(Sight sight) {
        this.id = sight.getId();
        this.name = sight.getName();
        this.location =sight.getLocation();
        this.price = sight.getPrice();
        this.price_info = sight.getPrice_info();
        this.url = sight.getUrl();
        this.tour = sight.getTour();
        this.sightCategory = sight.getSightCategory();        ;
    }

}
