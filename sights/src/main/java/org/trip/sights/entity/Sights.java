package org.trip.sights.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "sights")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sights {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "description")
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    @Column(name = "price")
    private Long price;

    @Lob
    @Column(name = "price_info")
    private String price_info;

    @Column(name = "url")
    private String url;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "location")
    private String location;

    @Column(name = "tour_id")
    private Long tour_id;

    public Sights(Long id, String name, String description, Long price, String priceInfo, String url, String coordinates, String location, Long tourId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.price_info = priceInfo;
        this.url = url;
        this.coordinates = coordinates;
        this.location = location;
        this.tour_id = tourId;
    }
}
