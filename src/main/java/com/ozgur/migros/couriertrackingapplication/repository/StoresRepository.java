package com.ozgur.migros.couriertrackingapplication.repository;

import com.ozgur.migros.couriertrackingapplication.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoresRepository extends JpaRepository<Store,Integer> {

}
