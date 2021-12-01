package com.address.addressproject.runner;

import com.address.addressproject.entity.City;
import com.address.addressproject.entity.Country;
import com.address.addressproject.service.CityService;
import com.address.addressproject.service.CountryService;
import com.address.addressproject.service.NeighborhoodService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class ApplicationRunner implements CommandLineRunner {

    private final CityService cityService;
    private final CountryService countryService;
    private final NeighborhoodService neighborhoodService;

    public ApplicationRunner (CityService cityService, CountryService countryService, NeighborhoodService neighborhoodService){
        this.cityService = cityService;
        this.countryService = countryService;
        this.neighborhoodService = neighborhoodService;
    }

    @Override
    public void run(String... args) throws Exception {

        Country country = Country.builder()
                .name("Bulgaria")
                .code_Alpha2("BG")
                .build();

        countryService.save(country);


        City city = City.builder()
                .name("Varna")
                .postCode("9000")
                .build();
        cityService.save(city);


        City city2 = City.builder()
                .name("Dobrich")
                .postCode("7000")
                .build();
        cityService.save(city2);

        City foundCity = cityService.findById(1L);












    }
}
