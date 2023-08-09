package ru.tripadvisor.tripsocial.entities;
import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "tour_statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "status")
    private List<Tour>tours;

}