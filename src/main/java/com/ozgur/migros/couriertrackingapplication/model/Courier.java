package com.ozgur.migros.couriertrackingapplication.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Courier {

    @Id
    private int courier_Id;
    private Double total_Travel_Distance;
    private Double lat;
    private Double lng;
    private ZonedDateTime zonedDateTime;
    private boolean enterence;
}
