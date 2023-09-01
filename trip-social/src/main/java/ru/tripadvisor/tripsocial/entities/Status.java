package ru.tripadvisor.tripsocial.entities;
import javax.persistence.*;
import lombok.Data;
import java.util.List;

@Entity
@Data
@Table(name = "dic$tour_statuses")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "active")
    private Integer active;

    @OneToMany(mappedBy = "status")
    private List<Tour>tours;

}