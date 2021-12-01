package com.address.addressproject.controller;

import com.address.addressproject.entity.Country;
import com.address.addressproject.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CountryController {
    private final CountryService countryService;
    @Autowired
    public CountryController (CountryService countryService){
        this.countryService = countryService;
    }


    @GetMapping (value = "/country")
    public Set<Country> findAll(){
        return countryService.findAll();
    }
    @PostMapping (value = "/save/country")
    public Country sava (Country country){
        return countryService.save(country);
    }

    @DeleteMapping (value = "/delete/country/{id}")
    public Country delete (@PathVariable Long id){
        return countryService.delete(id);
    }
}
