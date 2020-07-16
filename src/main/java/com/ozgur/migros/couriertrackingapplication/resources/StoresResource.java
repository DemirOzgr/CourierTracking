package com.ozgur.migros.couriertrackingapplication.resources;

import com.ozgur.migros.couriertrackingapplication.model.Stores;
import com.ozgur.migros.couriertrackingapplication.repository.StoresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stroes")
public class StoresResource {

    private final StoresRepository storesRepository;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Stores addStroes(@RequestBody Stores stores){
        return storesRepository.save(stores);
    }

}
