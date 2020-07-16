package com.ozgur.migros.couriertrackingapplication.resources;

import com.ozgur.migros.couriertrackingapplication.model.Courier;
import com.ozgur.migros.couriertrackingapplication.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;

@RestController
@RequiredArgsConstructor
@RequestMapping("/couriers")
public class CourierResource {

    private final CourierRepository courierRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Courier addCourier(@RequestBody Courier courier){
        courier.setZonedDateTime(ZonedDateTime.now());
        return courierRepository.save(courier);}
}
