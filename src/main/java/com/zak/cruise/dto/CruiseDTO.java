package com.zak.cruise.dto;

import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Route;
import com.zak.cruise.entity.Ship;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Controller
@ToString
@Getter
@Setter
public class CruiseDTO {
    private Long id;
    private String nameOfCruise;
    private LocalDate date;
    private Time time;
    private int cost;
    private int numberOfSeats;
    private int duration;
    private Route route;
    private Ship ship;

    public CruiseDTO() {
    }

    public CruiseDTO(String nameOfCruise, LocalDate date, Time time, int cost, int numberOfSeats, int duration, Route route, Ship ship) {
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
