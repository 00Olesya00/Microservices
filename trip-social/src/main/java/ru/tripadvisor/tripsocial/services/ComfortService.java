package ru.tripadvisor.tripsocial.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.tripadvisor.tripsocial.entities.Comfort;
import ru.tripadvisor.tripsocial.repositories.ComfortRepository;
import ru.tripadvisor.tripsocial.specifications.ComfortsSpecifications;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ComfortService {
   private final ComfortRepository comfortRepository;

    public Page<Comfort> findAll(String namePart, Double minPrice, Double maxPrice, Integer page){

        Specification<Comfort> specification = Specification.where(null);
        //select c from Comfort c where true
        if (minPrice != null){
            specification = specification.and(ComfortsSpecifications.priceGreaterOrElseThan(minPrice));
            //select c from Comfort c where true AND c.price > minPrice
        }
        if (maxPrice != null){
            specification = specification.and(ComfortsSpecifications.priceLessThenOrEqualsThan(maxPrice));
            //select c from Comfort c where true AND c.price > minPrice AND c.price>maxPrice
        }
        if (namePart != null){
            specification = specification.and(ComfortsSpecifications.nameLike(namePart));
            // select c from Comfort c where true AND c.price > minPrice AND c.Price < maxPrice AND c.name LIKE %namePart
        }

        return comfortRepository.findAll(specification, PageRequest.of(page-1,5));
    }

    public Optional<Comfort> findById(Long id) {

        return comfortRepository.findById(id);
    }

    public boolean  existsById(Long id) {

        return comfortRepository.existsById(id);
    }

    public void deleteById(Long id) {

        comfortRepository.deleteById(id);
    }

    public Comfort saveNewComfort(Comfort newComfort) {
       return comfortRepository.save(newComfort);

    }

    public Comfort updateComfort(Long id, Comfort updatedComfort) {
       Comfort comfort = comfortRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid travel ID"));
        comfort.setName(updatedComfort.getName());
        comfort.setPrice(updatedComfort.getPrice());
        comfort.setPrice_info(updatedComfort.getPrice_info());
        comfort.setInfo(updatedComfort.getInfo());
        comfort.setUrl(updatedComfort.getUrl());

        return comfortRepository.save(comfort);
    }


    public Iterable<Comfort> findAll(Integer page) {
        Specification<Comfort> specification = Specification.where(null);
        Iterable<Comfort> comforts =  comfortRepository.findAll(specification, PageRequest.of(page-1,5));

        return comforts;
    }
}
