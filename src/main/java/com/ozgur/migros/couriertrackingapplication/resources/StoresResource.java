package com.ozgur.migros.couriertrackingapplication.resources;

import com.ozgur.migros.couriertrackingapplication.model.Store;
import com.ozgur.migros.couriertrackingapplication.repository.StoresRepository;
import com.ozgur.migros.couriertrackingapplication.service.StoreCache;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class StoresResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(StoresResource.class);

    private final StoreCache storeCache;

    private final StoresRepository storesRepository;
    @RequestMapping(value = "", method = RequestMethod.POST)
    public Store addStore(@RequestBody Store store){
        LOGGER.info("{} Migros mağazası ekleniyor", store);
        storesRepository.save(store);
        storeCache.refreshCache();
        return store;
    }
}
