package com.ozgur.migros.couriertrackingapplication.dto;

import java.time.ZonedDateTime;

public class TrackingDto {

    private ZonedDateTime zonedDateTime;
    private int courier_Id;
    private Double lat;
    private Double lng;

    public TrackingDto(ZonedDateTime zonedDateTime, int courier_Id, Double lat, Double lng) {
        this.zonedDateTime = zonedDateTime;
        this.courier_Id = courier_Id;
        this.lat = lat;
        this.lng = lng;
    }

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }

    public int getCourier_Id() {
        return courier_Id;
    }

    public void setCourier_Id(int courier_Id) {
        this.courier_Id = courier_Id;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
