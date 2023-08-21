package ru.tripadvisor.tripsocial.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.tripadvisor.tripsocial.converters.SightConverter;
import ru.tripadvisor.tripsocial.dto.SightDto;
import ru.tripadvisor.tripsocial.entities.Sight;
import ru.tripadvisor.tripsocial.exceptions.ResourceNotFoundException;
import ru.tripadvisor.tripsocial.repositories.SightRepository;
import ru.tripadvisor.tripsocial.services.SightService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/sights")
public class SightController {
    private final SightService sightService;
    private final SightConverter sightConverter;
    private final SightRepository sightRepository;


    @GetMapping()
    public Page<SightDto> getAllSights(
            @RequestParam (name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "name_part", required = false) String namePart,
            @RequestParam (name = "min_price", required = false) Double minPrice,
            @RequestParam (name = "max_price", required = false) Double maxPrice
    ) {
        if (page<1){
            page = 1;
        }
        return sightService.findAll(namePart,minPrice,maxPrice, page).map(
                s-> sightConverter.entityToDto(s));

    }

   // удаление
    @DeleteMapping ("/{id}")
    public void  deleteSightById( @PathVariable Long id) {
        sightService.deleteById(id);

    }

    //Сохранение нового
    @PostMapping("/create_sight")
    public SightDto saveNewSight(@RequestBody SightDto newSightDto) {
        Sight sight = sightConverter.dtoToEntity(newSightDto);
        sight = sightService.saveNewSight(sight);
        return sightConverter.entityToDto(sight);
    }

    // переход на стр детальнее
    @GetMapping("/details_sight/{id}")
    public SightDto getDetailsSightById( @PathVariable(value = "id") Long id) {
        Sight sight = sightService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sight not found, id: " + id));
        return  sightConverter.entityToDto(sight);

    }

    // переход на для редактирования
    @GetMapping("/edit_sight/{id}")
    public SightDto editComfort( @PathVariable(value = "id") Long id) {
        Sight sight = sightService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Sight not found, id: " + id));
        return  sightConverter.entityToDto(sight);
    }

    // сохранение изменений при редактировании
    @PostMapping("/edit_sight/{id}")
    public SightDto updateSightPost( @PathVariable(value = "id") Long id, @RequestBody SightDto updateSightDto) {
        Sight sight = sightConverter.dtoToEntity(updateSightDto);
        sight = sightService.updateSight(id,sight);
        return sightConverter.entityToDto(sight);
    }

}
