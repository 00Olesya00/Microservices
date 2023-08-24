package org.trip.sights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.trip.sights.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category c where c.name like ?1")
    Category findByName(String name);

}