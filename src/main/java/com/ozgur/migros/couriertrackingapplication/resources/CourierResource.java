package com.ozgur.migros.couriertrackingapplication.resources;

import com.ozgur.migros.couriertrackingapplication.model.TrackingData;
import com.ozgur.migros.couriertrackingapplication.service.CourierService;
import com.ozgur.migros.couriertrackingapplication.service.DistanceService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/couriers")
public class CourierResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(CourierResource.class);
    private final CourierService courierService;
    private final DistanceService distanceService;


    @RequestMapping(value = "", method = RequestMethod.POST)
    public void trackCourier(@RequestBody TrackingData trackingData) {
        LOGGER.info("Courier Track {} geldi", trackingData);
        courierService.save(trackingData);
    }

    @RequestMapping(value = "/{id}/totalTravelDistance", method = RequestMethod.GET)
    public Double calculateRadius(@PathVariable("id") Long id) {
        LOGGER.info("{} id'li kurye için hesaplama yapılıyor", id);
        return distanceService.totalTravelDistanceByCourier(id);
    }
}
