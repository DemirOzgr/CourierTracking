package com.ozgur.migros.couriertrackingapplication.repository;

import com.ozgur.migros.couriertrackingapplication.model.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier,Integer> {
}
