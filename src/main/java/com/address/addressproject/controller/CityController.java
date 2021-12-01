package com.address.addressproject.controller;

import com.address.addressproject.entity.City;
import com.address.addressproject.service.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class CityController {

    private CityService cityService;

    public CityController (CityService cityService){
        this.cityService = cityService;
    }
    @GetMapping (value = "/cities")
    public Set<City> findCities (){
        return cityService.findAll();
    }
    @PostMapping (value = "/save/cities")
    public City save (@RequestBody City city){
        return cityService.save(city);
    }

    @DeleteMapping (value = "/delete/city/{id}")
    public City delete (@PathVariable Long id){

        return cityService.delete(id);
    }
}
