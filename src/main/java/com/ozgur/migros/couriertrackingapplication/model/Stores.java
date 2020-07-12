package com.ozgur.migros.couriertrackingapplication.model;

import lombok.Builder;

@Builder
public class Stores {

    private String name;
    private Double lat;
    private Double lng;

}
