package com.ozgur.migros.couriertrackingapplication.web;

import com.ozgur.migros.couriertrackingapplication.model.Courier;
import com.ozgur.migros.couriertrackingapplication.model.Stores;
import com.ozgur.migros.couriertrackingapplication.repository.CourierRepository;
import com.ozgur.migros.couriertrackingapplication.repository.StoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class StoresAndCourierController {

    @Autowired
    private StoresRepository storesRepository;

    @Autowired
    private CourierRepository courierRepository;

    @PostMapping("/addStroes")
    public Stores addStroes(@RequestBody Stores stores){
        return storesRepository.save(stores);
    }

    @PostMapping("/addCourier")
    public Courier addCourier(@RequestBody Courier courier){
        courier.setZonedDateTime(ZonedDateTime.now());
        return courierRepository.save(courier);}
}
