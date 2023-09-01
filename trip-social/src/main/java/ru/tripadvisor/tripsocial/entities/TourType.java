package ru.tripadvisor.tripsocial.entities;
import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "tour_types")
public class TourType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Integer active;

    @OneToMany(mappedBy = "tourType")
    private List<Tour>tours;

}



