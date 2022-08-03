package com.zak.cruise.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Time;
import java.time.LocalDate;

@Entity
@Table(name = "cruise")
@Getter
@Setter
public class Cruise {
    @Id
    @Column(name = "idcruise")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name_of_cruise")
    private String nameOfCruise;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "time")
    private Time time;

    @Column(name = "cost")
    private int cost;

    @Column(name = "number_of_seats")
    private int numberOfSeats;

    @Column(name = "duration")
    private int duration;

    @ManyToOne
    @JoinColumn(name = "route_id_route")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "ship_id_ship")
    private Ship ship;

    public Cruise() {
    }

    public Cruise(String nameOfCruise, LocalDate date, Time time, int cost, int numberOfSeats, int duration, Route route, Ship ship) {
        this.nameOfCruise = nameOfCruise;
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.numberOfSeats = numberOfSeats;
        this.duration = duration;
        this.route = route;
        this.ship = ship;
    }
}
