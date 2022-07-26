package com.zak.cruise.entity;

public class Route {
    private String startPlace;
    private String finishPlace;

    public Route(String startPlace, String finishPlace) {
        this.startPlace = startPlace;
        this.finishPlace = finishPlace;
    }

    public String getStartPlace() {
        return startPlace;
    }

    public void setStartPlace(String startPlace) {
        this.startPlace = startPlace;
    }

    public String getFinishPlace() {
        return finishPlace;
    }

    public void setFinishPlace(String finishPlace) {
        this.finishPlace = finishPlace;
    }
}
