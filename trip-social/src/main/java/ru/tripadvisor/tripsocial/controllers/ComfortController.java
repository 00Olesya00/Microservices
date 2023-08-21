package ru.tripadvisor.tripsocial.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.tripadvisor.tripsocial.converters.ComfortConverter;
import ru.tripadvisor.tripsocial.dto.ComfortDto;
import ru.tripadvisor.tripsocial.entities.Comfort;
import ru.tripadvisor.tripsocial.exceptions.ResourceNotFoundException;
import ru.tripadvisor.tripsocial.services.ComfortService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/comforts")
public class ComfortController {
    private final ComfortService comfortService;
    private final ComfortConverter comfortConverter;


    @GetMapping()
    public Page<ComfortDto> getAllComforts(
            @RequestParam (name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "name_part", required = false) String namePart,
            @RequestParam (name = "min_price", required = false) Double minPrice,
            @RequestParam (name = "max_price", required = false) Double maxPrice
    ) {
        if (page<1){
            page = 1;
        }
        return comfortService.findAll(namePart,minPrice,maxPrice, page).map(
                c-> comfortConverter.entityToDto(c));

    }

   // удаление
    @DeleteMapping ("/{id}")
    public void  deleteComfortById( @PathVariable Long id) {
        comfortService.deleteById(id);

    }

    //Сохранение нового
    @PostMapping("/create_comfort")
    public ComfortDto saveNewComfort(@RequestBody ComfortDto newComfortDto) {
        Comfort comfort = comfortConverter.dtoToEntity(newComfortDto);
        comfort = comfortService.saveNewComfort(comfort);
        return comfortConverter.entityToDto(comfort);
    }

    // переход на стр детальнее
    @GetMapping("/details_comfort/{id}")
    public ComfortDto getDetailsComfortById( @PathVariable(value = "id") Long id) {
        Comfort comfort = comfortService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Comfort not found, id: " + id));
        return  comfortConverter.entityToDto(comfort);

    }

    // переход на для редактирования
    @GetMapping("/edit_comfort/{id}")
    public ComfortDto editComfort( @PathVariable(value = "id") Long id) {
        Comfort comfort = comfortService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Comfort not found, id: " + id));
        return  comfortConverter.entityToDto(comfort);
    }

    // сохранение изменений при редактировании
    @PostMapping("/edit_comfort/{id}")
    public ComfortDto updateComfortPost( @PathVariable(value = "id") Long id, @RequestBody ComfortDto updateComfortDto) {
        Comfort comfort = comfortConverter.dtoToEntity(updateComfortDto);
        comfort = comfortService.updateComfort(id,comfort);
        return comfortConverter.entityToDto(comfort);
    }

}
