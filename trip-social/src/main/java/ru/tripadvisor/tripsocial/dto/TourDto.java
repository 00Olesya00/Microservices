package ru.tripadvisor.tripsocial.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.tripadvisor.tripsocial.entities.Tour;
import java.sql.Date;

// в этом классе мы показываем только поля, которые хотим, что бы были доступны для пользователей
//класс для передачи данных
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourDto {

    private Long id;
    private String name;
    private String about;
   private Date startDate;
    private Date endDate;
    //    Точка отправления (адрес)
    private String departureLocation;
    //    Точка назначения (адрес)
    private String destinationLocation;


    public TourDto(Tour tour) {
        this.id = tour.getId();
        this.name = tour.getName();
        this.about = tour.getAbout();
        this.startDate = tour.getStartDate();
        this.endDate = tour.getEndDate();
        this.departureLocation = tour.getDepartureLocation();
        this.destinationLocation =tour.getDestinationLocation();

    }
}
