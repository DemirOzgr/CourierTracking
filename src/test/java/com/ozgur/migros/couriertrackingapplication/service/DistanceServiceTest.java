package com.ozgur.migros.couriertrackingapplication.service;

import com.ozgur.migros.couriertrackingapplication.model.CourierTrack;
import com.ozgur.migros.couriertrackingapplication.model.Store;
import com.ozgur.migros.couriertrackingapplication.repository.CourierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class DistanceServiceTest {

    @InjectMocks
    private DistanceService distanceService;
    @Mock
    private CourierRepository repository;
    @Mock
    private StoreCache cache;

    @BeforeEach
    public void before() {
    }

    @Test
    public void should_return_false_when_courier_tracks_are_empty() {
        boolean expected = false;
        when(repository.findCourierByCourierAndTimeIsBetween(any(), any(), any())).thenReturn(null);

        boolean actual = distanceService.isCourierAtAnyStore(1L);

        assertEquals(expected, actual);
    }

    @Test
    public void should_return_false_when_courier_is_not_around_any_store() {
        boolean expected = false;
        Long courierId = 1234L;

        CourierTrack courierTrack1 = CourierTrack.builder().courier(courierId).lat(1D).lng(1D).time(ZonedDateTime.now().minusSeconds(5)).build();
        CourierTrack courierTrack2 = CourierTrack.builder().courier(courierId).lat(2D).lng(2D).time(ZonedDateTime.now().minusSeconds(3)).build();

        when(repository.findCourierByCourierAndTimeIsBetween(eq(courierId), any(), any())).thenReturn(Arrays.asList(courierTrack1, courierTrack2));

        Store store = new Store();
        store.setId(1L);
        store.setLat(3D);
        store.setLng(3D);
        store.setName("Test Store");

        when(cache.getStores()).thenReturn(Collections.singletonList(store));

        boolean actual = distanceService.isCourierAtAnyStore(courierId);

        assertEquals(expected, actual);
    }

    @Test
    public void should_return_true_when_courier_is_around_a_store() {
        boolean expected = true;
        Long courierId = 1234L;

        CourierTrack courierTrack1 = CourierTrack.builder().courier(courierId).lat(40.9632463D).lng(29.0630908D).time(ZonedDateTime.now().minusSeconds(5)).build();
        CourierTrack courierTrack2 = CourierTrack.builder().courier(courierId).lat(41.9632463D).lng(28.0630908D).time(ZonedDateTime.now().minusSeconds(3)).build();

        when(repository.findCourierByCourierAndTimeIsBetween(eq(courierId), any(), any())).thenReturn(Arrays.asList(courierTrack1, courierTrack2));

        Store store = new Store();
        store.setId(1L);
        store.setLat(courierTrack1.getLat());
        store.setLng(courierTrack1.getLng());
        store.setName("Test Store");

        when(cache.getStores()).thenReturn(Collections.singletonList(store));

        boolean actual = distanceService.isCourierAtAnyStore(courierId);

        assertEquals(expected, actual);

    }

    @Test
    public void should_return_zero_total_travel_distance_when_courier_track_data_not_found(){
        Long courierId = 100L;
        Double expected = 0D;

        when(repository.findCourierTrackByCourierOrderByTime(eq(courierId))).thenReturn(null);

        Double actual = distanceService.totalTravelDistanceByCourier(courierId);

        assertEquals(expected, actual);
    }

    @Test
    public void should_return_total_travel_distance(){
        Long courierId = 100L;
        Double expected = 23.77005591745178D;

        CourierTrack courierTrack1 = CourierTrack.builder().courier(courierId).lat(40.9632463D).lng(29.0630908D).time(ZonedDateTime.now().minusSeconds(5)).build();
        CourierTrack courierTrack2 = CourierTrack.builder().courier(courierId).lat(40.9634463D).lng(29.0631908D).time(ZonedDateTime.now().minusSeconds(3)).build();

        when(repository.findCourierTrackByCourierOrderByTime(eq(courierId))).thenReturn(Arrays.asList(courierTrack1, courierTrack2));

        Double actual = distanceService.totalTravelDistanceByCourier(courierId);

        assertEquals(expected, actual);
    }

}
