package ru.tripadvisor.tripsocial.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import ru.tripadvisor.tripsocial.entities.Tour;
import ru.tripadvisor.tripsocial.repositories.TourRepository;
import ru.tripadvisor.tripsocial.specifications.ToursSpecifications;

import java.sql.Date;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourService {
   private final TourRepository tourRepository;

    public Page<Tour> findALL(String namePart, Date minStartDate, Date maxStartDate, Integer page){

        Specification<Tour> specification = Specification.where(null);
        //select t from Tour t where true

        if (minStartDate != null){
            specification = specification.and(ToursSpecifications.startDateGreaterOrElseThan(minStartDate));
            //select t from Tour t where true AND t.startDate > minStartDate
        }
        if (maxStartDate != null){
            specification = specification.and(ToursSpecifications.startDateLessThenOrEqualsThan(maxStartDate));

            //select t from Tour t where true AND t.startDate > minStartDate AND t.startDate>maxStartDate
        }
        if (namePart != null){
            specification = specification.and(ToursSpecifications.namelike(namePart));

            // select t from Tour t where true AND t.startDate > minStartDate AND t.startDate < maxStartDate AND t.name LIKE %namePart
        }
        return tourRepository.findAll(specification, PageRequest.of(page-1,5));

    }
       public Optional<Tour> findById(Long id) {
        return tourRepository.findById(id);
       }
    public boolean  existsById(Long id) {

        return tourRepository.existsById(id);
    }



    public void deleteById(Long id) {
        tourRepository.deleteById(id);
    }



    public void createNewTour(  String name,  String about, Date startDate, Date endDate,  String departureLocation, String  destinationLocation) {
        Tour tour = new Tour(name,about,startDate,endDate,departureLocation,destinationLocation);
        tourRepository.save(tour);

    }


    public void updateTour( Long id,  String name,  String about, Date startDate, Date endDate,  String departureLocation, String  destinationLocation) {
        Tour tour = tourRepository.findById(id).orElseThrow();
        tour.setName(name);
        tour.setAbout(about);
        tour.setStartDate(startDate);
        tour.setEndDate(endDate);
        tour.setDepartureLocation(departureLocation);
        tour.setDestinationLocation(destinationLocation);
        tourRepository.save(tour);

    }

    public void addCommentTour( Long id,  String comment) {
        Tour tour = tourRepository.findById(id).orElseThrow();

        tour.setComment(comment);
        tourRepository.save(tour);

    }



// выводит только одну страницу с 5 объектами
    public Iterable<Tour> findAll(Integer page) {
        Specification<Tour> specification = Specification.where(null);
        Iterable<Tour> tours =  tourRepository.findAll(specification, PageRequest.of(page-1,5));
        return tours;
    }
}
