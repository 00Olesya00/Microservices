package ru.tripadvisor.tripsocial.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.tripadvisor.tripsocial.converters.TourConverter;
import ru.tripadvisor.tripsocial.dto.TourDto;
import ru.tripadvisor.tripsocial.entities.Tour;
import ru.tripadvisor.tripsocial.exceptions.ResourceNotFoundException;
import ru.tripadvisor.tripsocial.services.TourService;
import java.sql.Date;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/tours")
public class TourController {
    private final TourService tourService;
    private final TourConverter tourConverter;


    @GetMapping()
    public Page<TourDto> getAllTours(
            @RequestParam (name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "name_part", required = false) String namePart,
            @RequestParam (name = "min_start_date", required = false) Date minStartDate,
            @RequestParam (name = "max_start_date", required = false) Date maxStartDate
    ) {
        if (page<1){
            page = 1;
        }
        return tourService.findALL(namePart,minStartDate,maxStartDate, page).map(
                t-> tourConverter.entityToDto(t));

    }

   // удаление тура
    @DeleteMapping ("/{id}")
    public void  deleteTourById( @PathVariable Long id) {
        tourService.deleteById(id);

    }

    //Сохранение нового тура
    @PostMapping("/create_tour")
    public TourDto saveNewTour(@RequestBody TourDto newTourDto) {
        Tour tour = tourConverter.dtoToEntity(newTourDto);
        tour = tourService.saveNewTour(tour);
        return tourConverter.entityToDto(tour);
    }

    // переход на стр детальнее
    @GetMapping("/details_tour/{id}")
    public TourDto getDetailsTourById( @PathVariable(value = "id") Long id) {
        Tour tour = tourService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Tour not found, id: " + id));
        return  tourConverter.entityToDto(tour);
    }

    @GetMapping("/edit_tour/{id}")
    public TourDto editTour( @PathVariable(value = "id") Long id) {
        Tour tour = tourService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Tour not found, id: " + id));
        return  tourConverter.entityToDto(tour);
    }


    // TODO редактирование тура/?
    @PostMapping("/edit_tour/{id}")
    public TourDto updateTourPost( @PathVariable(value = "id") Long id, @RequestBody TourDto updateTourDto) {
        Tour tour = tourConverter.dtoToEntity(updateTourDto);
        tour = tourService.updateTour(id,tour);
        return tourConverter.entityToDto(tour);
    }

}
