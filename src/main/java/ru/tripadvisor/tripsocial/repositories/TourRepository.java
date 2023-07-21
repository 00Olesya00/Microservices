package ru.tripadvisor.tripsocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.tripadvisor.tripsocial.entities.Tour;

import java.util.Optional;
@Repository
public interface TourRepository extends JpaRepository <Tour,Long>, JpaSpecificationExecutor<Tour> {


    @Query("select t from Tour t where t.name = ?1")

    Optional<Tour> findByName(String name);
}


