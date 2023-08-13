package ru.tripadvisor.tripsocial.converters;

import org.springframework.stereotype.Component;
import ru.tripadvisor.tripsocial.dto.ComfortDto;
import ru.tripadvisor.tripsocial.entities.Comfort;

@Component
public class ComfortConverter {


    //дто записываем в сущность
    public Comfort dtoToEntity(ComfortDto comfortDto){
        return new Comfort(comfortDto.getName(),
                comfortDto.getPrice(),
                comfortDto.getPrice_info(),
                comfortDto.getInfo(),
                comfortDto.getUrl(),
                comfortDto.getTour());
    }

    // сущность перегоняем в дто
    public ComfortDto entityToDto(Comfort comfort){
        return new ComfortDto(comfort.getId(),
                comfort.getName(),
                comfort.getPrice(),
                comfort.getPrice_info(),
                comfort.getInfo(),
                comfort.getUrl(),
                comfort.getTour());
    }


}
