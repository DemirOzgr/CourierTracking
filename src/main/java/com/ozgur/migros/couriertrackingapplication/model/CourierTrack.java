package com.ozgur.migros.couriertrackingapplication.model;

import lombok.*;

import javax.persistence.*;
import java.time.ZonedDateTime;

@Table(name = "Courier_Track")
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourierTrack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long courier;
    private Double lat;
    private Double lng;
    private ZonedDateTime time;

}
