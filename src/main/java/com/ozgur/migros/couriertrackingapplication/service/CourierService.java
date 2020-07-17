package com.ozgur.migros.couriertrackingapplication.service;

import com.ozgur.migros.couriertrackingapplication.model.CourierTrack;
import com.ozgur.migros.couriertrackingapplication.model.TrackingData;
import com.ozgur.migros.couriertrackingapplication.repository.CourierRepository;
import com.ozgur.migros.couriertrackingapplication.resources.StoresResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CourierService {

    private static final Logger logger = LoggerFactory.getLogger(CourierService.class);
    private final CourierRepository repository;
    private final DistanceService distanceService;

    public void save(TrackingData tracking) {
        if (distanceService.isCourierAtAnyStore(tracking.getCourier())) {
            logger.warn("Kurye zaten magazada {}",tracking.getCourier());
            return;
        }
        CourierTrack courierTrack = CourierTrack.builder().courier(tracking.getCourier()).lat(tracking.getLat()).lng(tracking.getLng()).time(tracking.getTime()).build();
        repository.save(courierTrack);
        logger.info("Kurye eklendi {}", courierTrack);
    }
}
