package ru.tripadvisor.tripsocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.tripadvisor.tripsocial.entities.Comfort;
import ru.tripadvisor.tripsocial.entities.Sight;

import java.util.Optional;

@Repository
public interface SightRepository extends JpaRepository <Sight,Long>, JpaSpecificationExecutor<Sight> {

//    @Query("select s from Sight s where s.name = ?1")

    Optional<Sight> findByName(String name);
}


