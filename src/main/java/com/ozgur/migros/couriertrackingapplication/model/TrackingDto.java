package com.ozgur.migros.couriertrackingapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TrackingDto {

    private ZonedDateTime zonedDateTime;
    private int courier_Id;
    private Double lat;
    private Double lng;
}
