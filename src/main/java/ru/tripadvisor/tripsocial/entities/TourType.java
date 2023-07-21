package ru.tripadvisor.tripsocial.entities;


import javax.persistence.*;
import java.util.Calendar;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tour_types")
public class TourType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;


    @OneToMany(mappedBy = "tourType")
    private List<Tour>tours;



}







//*	active	TINYINT DEFAULT 1	Доступен к  выбору/активный

