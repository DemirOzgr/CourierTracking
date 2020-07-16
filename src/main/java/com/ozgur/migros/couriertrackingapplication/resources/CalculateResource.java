package com.ozgur.migros.couriertrackingapplication.resources;

import com.ozgur.migros.couriertrackingapplication.model.TrackingDto;
import com.ozgur.migros.couriertrackingapplication.service.DistanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/calculate")
public class CalculateResource {

    private final DistanceService distanceService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<TrackingDto> calculateRadius(@RequestBody TrackingDto trackingDto){
        distanceService.courierService(trackingDto);
        return new ResponseEntity<TrackingDto>(trackingDto, HttpStatus.OK);
    }
}
