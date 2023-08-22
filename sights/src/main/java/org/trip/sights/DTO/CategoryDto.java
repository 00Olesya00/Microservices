package org.trip.sights.DTO;

import lombok.Value;
import org.trip.sights.entity.Category;

import java.io.Serializable;

/**
 * DTO for {@link org.trip.sights.entity.Category}
 */
@Value
public class CategoryDto implements Serializable {
    Long id;
    String name;

    public Category toEntity() {
        return new Category(id, name);
    }
}