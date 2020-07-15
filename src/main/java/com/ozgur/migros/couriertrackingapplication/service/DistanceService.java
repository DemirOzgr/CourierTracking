package com.ozgur.migros.couriertrackingapplication.service;

import com.ozgur.migros.couriertrackingapplication.dto.TrackingDto;
import com.ozgur.migros.couriertrackingapplication.model.Courier;
import com.ozgur.migros.couriertrackingapplication.model.Stores;
import com.ozgur.migros.couriertrackingapplication.repository.CourierRepository;
import com.ozgur.migros.couriertrackingapplication.repository.StoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistanceService {

    @Autowired
    private StoresRepository storesRepository;
    @Autowired
    private CourierRepository courierRepository;

    private List<Stores> stores;
    private Courier courier;
    private Double distance;
    boolean flag = false;

    public TrackingDto courierService(TrackingDto trackingDto){

        stores = storesRepository.findAll();
        trackingDto.setZonedDateTime(ZonedDateTime.now());

        if (courierRepository.findById(trackingDto.getCourier_Id())!=null){
            courier = courierRepository.findById(trackingDto.getCourier_Id()).get();
            if (courier.isEnterence() && trackingDto.getZonedDateTime().minusMinutes(1).compareTo(courier.getZonedDateTime())==1){
                courier.setEnterence(false);
            }
            for (Stores store: stores) {
                if (calculateDistance(trackingDto.getLat(), trackingDto.getLng(), store.getLat(), store.getLng()) <= 100) {
                    courier.setEnterence(true);
                    courier.setZonedDateTime(ZonedDateTime.now());
                    courierRepository.save(courier);
                    flag=true;
                }
            }
                if (flag!=true && !courier.isEnterence()){
                    distance = calculateDistance(courier.getLat(),courier.getLng(),trackingDto.getLat(),trackingDto.getLng());
                    distance+=courier.getTotal_Travel_Distance();
                    courier.setTotal_Travel_Distance(distance);
                    courier.setZonedDateTime(ZonedDateTime.now());
                    courierRepository.save(courier);
                    System.out.println(distance);
                }
            }else
            System.out.println("Aranan id bulunamadı");

        return trackingDto;
    }

    public Double calculateDistance(double latCourier, double lngCourier, double latMigros, double lngMigros) {

        double theta = lngCourier - lngMigros;
        double dist = Math.sin(deg2rad(latCourier)) * Math.sin(deg2rad(latMigros)) + Math.cos(deg2rad(latCourier)) * Math.cos(deg2rad(latMigros)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344 * 1000;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }
}
