package com.ozgur.migros.couriertrackingapplication.service;

import com.ozgur.migros.couriertrackingapplication.model.CourierTrack;
import com.ozgur.migros.couriertrackingapplication.model.TrackingData;
import com.ozgur.migros.couriertrackingapplication.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CourierService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourierService.class);
    private final CourierRepository repository;
    private final DistanceService distanceService;

    public void save(TrackingData tracking) {
        if (distanceService.isCourierAtAnyStore(tracking.getCourier())) {
            LOGGER.warn("Kurye zaten magazada {}",tracking.getCourier());
            return;
        }
        CourierTrack courierTrack = CourierTrack.builder().courier(tracking.getCourier()).lat(tracking.getLat()).lng(tracking.getLng()).time(tracking.getTime()).build();
        repository.save(courierTrack);
        LOGGER.info("Kurye eklendi {}", courierTrack);
    }
}
