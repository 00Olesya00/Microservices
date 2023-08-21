package ru.tripadvisor.tripsocial.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.tripadvisor.tripsocial.entities.Catering;
import java.util.Optional;

@Repository
public interface CateringRepository extends JpaRepository <Catering,Long>, JpaSpecificationExecutor<Catering> {

//    @Query("select c from Catering c where c.name = ?1")

    Optional<Catering> findByName(String name);
}


