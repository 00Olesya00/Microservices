package ru.tripadvisor.tripsocial.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "dic$sight_categories")
public class SightCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "sightCategory")
    private List<Sight>sights;

}




