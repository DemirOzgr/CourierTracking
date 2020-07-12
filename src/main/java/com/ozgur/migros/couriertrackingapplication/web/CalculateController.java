package com.ozgur.migros.couriertrackingapplication.web;

import com.ozgur.migros.couriertrackingapplication.dto.TrackingDto;
import com.ozgur.migros.couriertrackingapplication.service.CourierService;
import com.ozgur.migros.couriertrackingapplication.service.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CalculateController {

    private final CourierService courierService;

    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    public ResponseEntity<TrackingDto> calculateRadius(@RequestBody TrackingDto trackingDto){
        courierService.courierProcess(trackingDto);
        return new ResponseEntity<TrackingDto>(trackingDto, HttpStatus.OK);
    }
}
