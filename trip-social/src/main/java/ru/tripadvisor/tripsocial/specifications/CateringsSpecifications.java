package ru.tripadvisor.tripsocial.specifications;

import org.springframework.data.jpa.domain.Specification;
import ru.tripadvisor.tripsocial.entities.Catering;
import ru.tripadvisor.tripsocial.entities.Comfort;


public class CateringsSpecifications {

    //показать цену, которая больше или равен цене указанной
    public static Specification<Catering> priceGreaterOrElseThan(Double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("price"), price);
    }

    // показать цену, которая меньше или равен
    public static Specification<Catering> priceLessThenOrEqualsThan(Double price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get("price"), price);
    }

    // найти по названию
    public static Specification<Catering> nameLike(String namePart) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), String.format("%%%s%%",namePart));
    }



}
