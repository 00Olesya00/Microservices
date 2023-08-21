package ru.tripadvisor.tripsocial.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.tripadvisor.tripsocial.converters.CateringConverter;
import ru.tripadvisor.tripsocial.dto.CateringDto;
import ru.tripadvisor.tripsocial.entities.Catering;
import ru.tripadvisor.tripsocial.exceptions.ResourceNotFoundException;
import ru.tripadvisor.tripsocial.services.CateringService;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/caterings")
public class CateringController {
    private final CateringService cateringService;
    private final CateringConverter cateringConverter;


    @GetMapping()
    public Page<CateringDto> getAllCaterings(
            @RequestParam (name = "p", defaultValue = "1") Integer page,
            @RequestParam(name = "name_part", required = false) String namePart,
            @RequestParam (name = "min_price", required = false) Double minPrice,
            @RequestParam (name = "max_price", required = false) Double maxPrice
    ) {
        if (page<1){
            page = 1;
        }
        return cateringService.findAll(namePart,minPrice,maxPrice, page).map(
                c-> cateringConverter.entityToDto(c));

    }

   // удаление
    @DeleteMapping ("/{id}")
    public void  deleteCateringById( @PathVariable Long id) {
        cateringService.deleteById(id);

    }

    //Сохранение нового
    @PostMapping("/create_catering")
    public CateringDto saveNewCatering(@RequestBody CateringDto newCateringDto) {
        Catering catering = cateringConverter.dtoToEntity(newCateringDto);
       catering = cateringService.saveNewCatering(catering);
        return cateringConverter.entityToDto(catering);
    }

    // переход на стр детальнее
    @GetMapping("/details_catering/{id}")
    public CateringDto getDetailsCateringById( @PathVariable(value = "id") Long id) {
        Catering catering = cateringService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Catering not found, id: " + id));
        return  cateringConverter.entityToDto(catering);
    }

    //переход для редактирования
    @GetMapping("/edit_catering/{id}")
    public CateringDto editCatering( @PathVariable(value = "id") Long id) {
        Catering catering = cateringService.findById(id).orElseThrow(()-> new ResourceNotFoundException("Catering not found, id: " + id));
        return  cateringConverter.entityToDto(catering);
    }

    // сохранение изменений при редактировании
    @PostMapping("/edit_catering/{id}")
    public CateringDto updateCateringPost( @PathVariable(value = "id") Long id, @RequestBody CateringDto updateCateringDto) {
        Catering catering = cateringConverter.dtoToEntity(updateCateringDto);
        catering = cateringService.updateCatering(id,catering);
        return cateringConverter.entityToDto(catering);
    }
}
