package ru.tripadvisor.tripsocial.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.tripadvisor.tripsocial.entities.Sight;
import ru.tripadvisor.tripsocial.repositories.SightRepository;
import ru.tripadvisor.tripsocial.specifications.SightsSpecifications;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SightService {
   private final SightRepository sightRepository;

    public Page<Sight> findAll(String namePart, Double minPrice, Double maxPrice, Integer page){

        Specification<Sight> specification = Specification.where(null);
        //select s from Sight s where true

        if (minPrice != null){
            specification = specification.and(SightsSpecifications.priceGreaterOrElseThan(minPrice));
            //select s from Sight s where true AND s.price > minPrice
        }
        if (maxPrice != null){
            specification = specification.and(SightsSpecifications.priceLessThenOrEqualsThan(maxPrice));
            //select s from Sight s where true AND s.price > minPrice AND s.price>maxPrice
        }
        if (namePart != null){
            specification = specification.and(SightsSpecifications.nameLike(namePart));
            // select s from Sight s where true AND s.price > minPrice AND s.Price < maxPrice AND s.name LIKE %namePart
        }

        return sightRepository.findAll(specification, PageRequest.of(page-1,5));
    }

    public Optional<Sight> findById(Long id) {

        return sightRepository.findById(id);
    }

    public boolean  existsById(Long id) {

        return sightRepository.existsById(id);
    }

    public void deleteById(Long id) {

        sightRepository.deleteById(id);
    }

    public Sight saveNewSight(Sight newSight) {

       return sightRepository.save(newSight);
    }

    public Sight updateSight(Long id, Sight updatedSight) {
        Sight sight = sightRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid travel ID"));
        sight.setName(updatedSight.getName());
        sight.setLocation(updatedSight.getLocation());
        sight.setDescription(updatedSight.getDescription());
        sight.setPrice(updatedSight.getPrice());
        sight.setPrice_info(updatedSight.getPrice_info());
        sight.setUrl(updatedSight.getUrl());

        return sightRepository.save(sight);
    }


    public Iterable<Sight> findAll(Integer page) {
        Specification<Sight> specification = Specification.where(null);
        Iterable<Sight> sights  =  sightRepository.findAll(specification, PageRequest.of(page-1,5));

        return sights;
    }
}
