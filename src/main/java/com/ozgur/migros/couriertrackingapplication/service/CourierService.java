package com.ozgur.migros.couriertrackingapplication.service;

import com.ozgur.migros.couriertrackingapplication.dto.TrackingDto;
import com.ozgur.migros.couriertrackingapplication.model.Stores;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class CourierService {

    private final DistanceService distanceService;

    public String courierProcess(TrackingDto trackingDto){
        return "";
    }
}
