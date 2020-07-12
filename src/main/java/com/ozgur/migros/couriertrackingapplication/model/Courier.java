package com.ozgur.migros.couriertrackingapplication.model;

public class Courier {

    private int courierId;
    private Double totalTravelDistance;

    public int getCourierId() {
        return courierId;
    }

    public void setCourierId(int courierId) {
        this.courierId = courierId;
    }

    public Double getTotalTravelDistance() {
        return totalTravelDistance;
    }

    public void setTotalTravelDistance(Double totalTravelDistance) {
        this.totalTravelDistance = totalTravelDistance;
    }
}
