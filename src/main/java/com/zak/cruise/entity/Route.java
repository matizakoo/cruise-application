package com.zak.cruise.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "route")
@Getter
@Setter
public class Route {
    @Id
    @Column(name = "id_route")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "start_place")
    private String startPlace;

    @Column(name = "finish_place")
    private String finishPlace;

    public Route() {
    }

    public Route(String startPlace, String finishPlace) {
        this.startPlace = startPlace;
        this.finishPlace = finishPlace;
    }
}
