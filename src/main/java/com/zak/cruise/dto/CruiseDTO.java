package com.zak.cruise.dto;

import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Route;
import com.zak.cruise.entity.Ship;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;

import javax.persistence.Column;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Controller
@ToString
@Getter
@Setter
public class CruiseDTO {
    private Long id;
    private String nameOfCruise;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    
    private LocalTime time;

    private Long cost;
    
    private Long numberOfSeats;

    private Long duration;

    private Integer route;

    private Integer ship;
    private String formError;
    public CruiseDTO() {
    }

    public CruiseDTO(String nameOfCruise, LocalDate date, LocalTime time, Long cost, Long numberOfSeats, Long duration, Integer route, Integer ship) {
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
