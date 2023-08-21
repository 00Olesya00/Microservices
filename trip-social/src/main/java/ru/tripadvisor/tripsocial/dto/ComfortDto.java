package ru.tripadvisor.tripsocial.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tripadvisor.tripsocial.entities.Comfort;
import ru.tripadvisor.tripsocial.entities.Tour;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComfortDto {

    private Long id;
    private String name;
    private Double price;
    private String price_info;
    private String info;
    private String url;
    private Tour tour;


//    public ComfortDto(Comfort comfort) {
//        this.id = comfort.getId();
//        this.name = comfort.getName();
//        this.price =comfort.getPrice();
//        this.info= comfort.getInfo();
//        this.url = comfort.getUrl();
//    }


    public ComfortDto(String name, Double price, String price_info, String info, String url, Tour tour) {
        this.name = name;
        this.price = price;
        this.price_info = price_info;
        this.info = info;
        this.url = url;
        this.tour = tour;
    }


}
