package com.ozgur.migros.couriertrackingapplication.service;

import com.ozgur.migros.couriertrackingapplication.model.CourierTrack;
import com.ozgur.migros.couriertrackingapplication.model.TrackingData;
import com.ozgur.migros.couriertrackingapplication.repository.CourierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.ZonedDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CourierServiceTest {

    @InjectMocks
    private CourierService courierService;
    @Mock
    private CourierRepository repository;
    @Mock
    private DistanceService distanceService;

    @BeforeEach
    public void before() {
    }

    @Test
    public void should_save_tracking_data() {
        TrackingData data = getMockedTrackingData();

        when(distanceService.isCourierAtAnyStore(any())).thenReturn(false);
        courierService.save(data);

        verify(repository, only()).save(any(CourierTrack.class));
    }

    @Test
    public void should_not_save_tracking_data_when_courier_at_a_store() {
        TrackingData data = getMockedTrackingData();

        when(distanceService.isCourierAtAnyStore(any())).thenReturn(true);
        courierService.save(data);

        verify(repository, never()).save(any(CourierTrack.class));
    }

    private TrackingData getMockedTrackingData() {
        TrackingData data = new TrackingData();
        data.setCourier(1L);
        data.setLat(1D);
        data.setLng(2D);
        data.setTime(ZonedDateTime.now());
        return data;
    }

}
