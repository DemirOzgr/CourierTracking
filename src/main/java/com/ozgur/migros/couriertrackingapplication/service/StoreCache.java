package com.ozgur.migros.couriertrackingapplication.service;

import com.ozgur.migros.couriertrackingapplication.model.Store;
import com.ozgur.migros.couriertrackingapplication.repository.StoresRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class StoreCache {

    Logger logger = LoggerFactory.getLogger(StoreCache.class);

    private final StoresRepository repository;

    private List<Store> stores;

    @Autowired
    public StoreCache(StoresRepository repository) {
        this.repository = repository;
    }

    @PostConstruct
    public void init() {
        logger.info("Tüm mağazalar getiriliyor");
        this.stores = repository.findAll();
    }

    public List<Store> getStores() {
        return stores;
    }
}
