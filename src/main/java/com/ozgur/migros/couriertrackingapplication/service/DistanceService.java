package com.ozgur.migros.couriertrackingapplication.service;

import com.ozgur.migros.couriertrackingapplication.model.CourierTrack;
import com.ozgur.migros.couriertrackingapplication.repository.CourierRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistanceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DistanceService.class);
    private final StoreCache storeCache;
    private final CourierRepository courierRepository;

    public boolean isCourierAtAnyStore(Long courierId) {
        List<CourierTrack> courierTracks = courierRepository.findCourierByCourierAndTimeIsBetween(courierId, ZonedDateTime.now().minusMinutes(1), ZonedDateTime.now());

        if (CollectionUtils.isEmpty(courierTracks)) {
            return false;
        }
        return courierTracks.stream().anyMatch(courier -> isAroundAnyStore(courier.getLat(), courier.getLng()));
    }

    private boolean isAroundAnyStore(double lat, double lng) {
        return storeCache.getStores().stream().anyMatch(store -> calculateDistance(lat, lng, store.getLat(), store.getLng()) <= 100);
    }

    public Double totalTravelDistanceByCourier(Long id) {
        List<CourierTrack> courierTracks = courierRepository.findCourierTrackByCourierOrderByTime(id);

        if (CollectionUtils.isEmpty(courierTracks)) {
            LOGGER.warn("{} id'li kurye yok",id);
            return 0d;
        }

        double totalDistance = 0;
        for (int i = 0; i < courierTracks.size() - 1; i++) {
            totalDistance += calculateDistance(courierTracks.get(i).getLat(), courierTracks.get(i).getLng(), courierTracks.get(i + 1).getLat(), courierTracks.get(i + 1).getLng());
        }
        LOGGER.info("Kuryenin gittiği toplam yol {}",totalDistance);
        return totalDistance;
    }

    private Double calculateDistance(double latCourier, double lngCourier, double latMigros, double lngMigros) {

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
