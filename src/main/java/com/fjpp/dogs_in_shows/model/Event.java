package com.fjpp.dogs_in_shows.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate Date;

    @OneToMany(mappedBy = "event")
    private List<Show> shows = new ArrayList<>();

    private BigDecimal discountFor2Days;
}
