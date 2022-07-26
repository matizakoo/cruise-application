package com.zak.cruise.entity;

import java.sql.Time;
import java.time.LocalDate;

public class Cruise {
    private String nameOfCruise;
    private LocalDate localDate;
    private Time time;
    private double cost;
    private Integer numberOfSeats;
    private int duration;
    private Route route;
    private Ship ship;

    public Cruise(String nameOfCruise, LocalDate localDate,
                  Time time, double cost,
                  Integer numberOfSeats, int duration,
                  Route route, Ship ship) {
        this.nameOfCruise = nameOfCruise;
        this.localDate = localDate;
        this.time = time;
        this.cost = cost;
        this.numberOfSeats = numberOfSeats;
        this.duration = duration;
        this.route = route;
        this.ship = ship;
    }

    public String getNameOfCruise() {
        return nameOfCruise;
    }

    public void setNameOfCruise(String nameOfCruise) {
        this.nameOfCruise = nameOfCruise;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }
}
