package ru.tripadvisor.tripsocial.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.tripadvisor.tripsocial.entities.Tour;

import java.sql.Date;

public class ToursSpecifications {

    //показать дату, который больше или равен цене указанной
    public static Specification<Tour> startDateGreaterOrElseThan(Date startDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("startDate"), startDate);
    }

    // показать дату, который меньше или равен
    public static Specification<Tour> startDateLessThenOrEqualsThan(Date startDate) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("startDate"), startDate);
    }

    // найти по названию тура
    public static Specification<Tour> namelike(String namePart) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), String.format("%%%s%%",namePart));
    }



}
