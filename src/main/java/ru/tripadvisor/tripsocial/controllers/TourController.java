package ru.tripadvisor.tripsocial.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.tripadvisor.tripsocial.entities.Tour;
import ru.tripadvisor.tripsocial.services.TourService;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Optional;


@RequiredArgsConstructor
@Controller
public class TourController {
    private final TourService tourService;


//   todo  выводит только 1 страницу
    @GetMapping("/tour")
    public String findTourByAll(  @RequestParam (name = "p", defaultValue = "1") Integer page, Model model) {
       Iterable<Tour> tours = tourService.findAll(page);

        if (page<1){
            page = 1;

        }
        model.addAttribute("tours", tours);
        return "tour";
    }

    //todo поиск с фильтром
//    @GetMapping("/tour")
//    public Page<Tour> getAllTours(
//            @RequestParam (name = "p", defaultValue = "1") Integer page,
//            @RequestParam(name = "name_part", required = false) String namePart,
//            @RequestParam (name = "min_startDate", required = false) Date minStartDate,
//            @RequestParam (name = "max_startDate", required = false) Date maxStartDate
//
//    ) {
//        if (page<1){
//            page = 1;
//            //что бы не могли указать отрицательное значение
//        }
//
//        return tourService.findALL(namePart, minStartDate, maxStartDate, page).map(t-> new Tour(t.getAbout(),t.getName(),t.getStartDate(),t.getEndDate(),t.getDepartureLocation(),t.getDestinationLocation()));
//
//    }
//


// на стр добавить тур
    @GetMapping("/tour/add")
    public String tourAdd( Model model) {

        return "tour-add";
    }

// добавление тура
    @PostMapping("/tour/add")
    public String createNewTour(@RequestParam String name, @RequestParam String about, @RequestParam Date startDate, @RequestParam Date endDate, @RequestParam String departureLocation, @RequestParam String  destinationLocation) {

        tourService.createNewTour(name,about,startDate,endDate,departureLocation,destinationLocation);
        return "redirect:/tour";

    }

    // переход на стр детальнее
    @GetMapping("/tour/{id}")
    public String tourDetails( @PathVariable(value = "id") long id, Model model) {
        if(!tourService.existsById(id)){
            return "redirect:/tour";
        }
        Optional<Tour> tour = tourService.findById(id);
        ArrayList<Tour> res =new ArrayList<>();
        tour.ifPresent(res::add);
        model.addAttribute("tour",res);
        return "tour-details";
    }

    // переход на стр с редактированием
    @GetMapping("/tour/{id}/edit")
    public String editTour (@PathVariable(value = "id") long id, Model model) {
        if(!tourService.existsById(id)){
            return "redirect:/tour";
        }
        Optional<Tour> tour = tourService.findById(id);
        ArrayList<Tour> res =new ArrayList<>();
        tour.ifPresent(res::add);
        model.addAttribute("tour",res);
        return "tour-edit";
    }

    // редактирование тура
    @PostMapping("/tour/{id}/edit")
    public String updateTourPost( @PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String about,@RequestParam Date startDate,@RequestParam Date endDate, @RequestParam String departureLocation,@RequestParam String  destinationLocation, Model model) {
       tourService.updateTour(id,name,about,startDate,endDate,departureLocation,destinationLocation);

        return "redirect:/tour";
    }

    //удаление тура
    @PostMapping("/tour/{id}/delete")
    public String deleteTourPost( @PathVariable(value = "id") long id) {
        if(!tourService.existsById(id)){
            return "redirect:/tour";
        }
        tourService.deleteById(id);
        return "redirect:/tour";
    }

    //TODO добавление комментария  - добавляет 1 комент, перезаписывает
    @PostMapping("/tour/{id}/add_comment")
    public String updateTourPost( @PathVariable(value = "id") long id, @RequestParam String comment, Model model) {
        if (!comment.isEmpty()){
            tourService.addCommentTour(id,comment);
        }

        return "redirect:/tour";
    }



}
