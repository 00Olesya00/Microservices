package org.trip.sights.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.trip.sights.entity.Sights;

@Repository
public interface SightsRepository extends JpaRepository<Sights, Long> {
    void deleteByName(String name);
}