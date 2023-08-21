package ru.tripadvisor.tripsocial.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.tripadvisor.tripsocial.entities.Catering;
import ru.tripadvisor.tripsocial.repositories.CateringRepository;
import ru.tripadvisor.tripsocial.specifications.CateringsSpecifications;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CateringService {
   private final CateringRepository cateringRepository;

    public Page<Catering> findAll(String namePart, Double minPrice, Double maxPrice, Integer page){

        Specification<Catering> specification = Specification.where(null);
        //select c from Catering c where true
        if (minPrice != null){
            specification = specification.and(CateringsSpecifications.priceGreaterOrElseThan(minPrice));
            //select c from Catering c where true AND c.price > minPrice
        }
        if (maxPrice != null){
            specification = specification.and(CateringsSpecifications.priceLessThenOrEqualsThan(maxPrice));
            //select c from Catering c where true AND c.price > minPrice AND c.price>maxPrice
        }
        if (namePart != null){
            specification = specification.and(CateringsSpecifications.nameLike(namePart));
            // select c from Catering c where true AND c.price > minPrice AND c.Price < maxPrice AND c.name LIKE %namePart
        }

        return cateringRepository.findAll(specification, PageRequest.of(page-1,5));
    }

    public Optional<Catering> findById(Long id) {

        return cateringRepository.findById(id);
    }

    public boolean  existsById(Long id) {

        return cateringRepository.existsById(id);
    }

    public void deleteById(Long id) {

        cateringRepository.deleteById(id);
    }

    public Catering saveNewCatering(Catering newCatering) {

       return cateringRepository.save(newCatering);
    }

    public Catering updateCatering(Long id, Catering updatedCatering) {
        Catering catering = cateringRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid travel ID"));
        catering.setName(updatedCatering.getName());
        catering.setDescription(updatedCatering.getDescription());
        catering.setVisitDate(updatedCatering.getVisitDate());
        catering.setRating(updatedCatering.getRating());
        catering.setPrice(updatedCatering.getPrice());

        return cateringRepository.save(catering);
    }


    public Iterable<Catering> findAll(Integer page) {
        Specification<Catering> specification = Specification.where(null);
        Iterable<Catering> caterings =  cateringRepository.findAll(specification, PageRequest.of(page-1,5));
        return caterings;
    }
}
