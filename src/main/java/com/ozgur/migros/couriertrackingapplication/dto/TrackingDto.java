package com.ozgur.migros.couriertrackingapplication.dto;

import com.ozgur.migros.couriertrackingapplication.model.Courier;

public class TrackingDto {

    private Double time;
    private Courier courier;
    private Double lat;
    private Double lng;

    public TrackingDto(Double time, Courier courier, Double lat, Double lng) {
        this.time = time;
        this.courier = courier;
        this.lat = lat;
        this.lng = lng;
    }

    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
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

    @Override
    public String toString() {
        return "id: " + getCourier().getCourierId() + " toplamYol: " + getCourier().getTotalTravelDistance() + " zaman: " +
                getTime() + " lat: " + getLat() + " lng: " + getLng();
    }
}
