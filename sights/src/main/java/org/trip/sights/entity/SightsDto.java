package org.trip.sights.entity;

import lombok.Value;
import org.trip.sights.DTO.CategoryDto;

import java.io.Serializable;

/**
 * DTO for {@link Sights}
 */
@Value
public class SightsDto implements Serializable {
    Long id;
    String name;
    String description;
    Long price;
    String price_info;
    String url;
    CategoryDto category;
    String coordinates;
    String location;
    Long tour_id;

    public Sights toEntity() {
        return new Sights(id, name, description, price, price_info, url, category.toEntity(), coordinates, location, tour_id);
    }
}