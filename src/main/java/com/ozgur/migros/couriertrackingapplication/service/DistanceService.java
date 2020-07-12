package com.ozgur.migros.couriertrackingapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistanceService {

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
