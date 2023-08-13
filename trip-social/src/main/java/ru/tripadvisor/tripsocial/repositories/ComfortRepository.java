package ru.tripadvisor.tripsocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.tripadvisor.tripsocial.entities.Catering;
import ru.tripadvisor.tripsocial.entities.Comfort;

import java.util.Optional;

@Repository
public interface ComfortRepository extends JpaRepository <Comfort,Long>, JpaSpecificationExecutor<Comfort> {

//    @Query("select c from Comfort c where c.name = ?1")

    Optional<Comfort> findByName(String name);
}


