package com.ozgur.migros.couriertrackingapplication.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class TrackingData {

    private Long courier;
    private Double lat;
    private Double lng;
    private ZonedDateTime time;

}
