package com.ozgur.migros.couriertrackingapplication.repository;

import com.ozgur.migros.couriertrackingapplication.model.CourierTrack;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.ZonedDateTime;
import java.util.List;

public interface CourierRepository extends JpaRepository<CourierTrack,Integer> {

    List<CourierTrack> findCourierByCourierAndTimeIsBetween(Long courier, ZonedDateTime start, ZonedDateTime end);

    List<CourierTrack> findCourierTrackByCourierOrderByTime(Long courier);

}
