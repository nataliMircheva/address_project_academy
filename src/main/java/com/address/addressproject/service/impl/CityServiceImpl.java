package com.address.addressproject.service.impl;


import com.address.addressproject.entity.City;
import com.address.addressproject.entity.Country;
import com.address.addressproject.repository.CityRepository;
import com.address.addressproject.service.CityService;
import com.address.addressproject.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CityServiceImpl implements CityService {

   private final CityRepository cityRepository;
   private final CountryService countryService;

   public  CityServiceImpl (CityRepository cityRepository, CountryService countryService){
       this.cityRepository = cityRepository;
       this.countryService =countryService;

   }

    @Override
    public City save(City city) {

        Country bulgaria = countryService.findById(1L);
        City newCity = City.builder()
                .name(city.getName())
                .postCode(city.getPostCode())
                .country(bulgaria)
                .build();

        return cityRepository.save(newCity);
    }

    @Override
    public City findById(Long id) {
        return cityRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Not found city with this id: %d", id)));
    }

    @Override
    public Set<City> findAll() {

       return new HashSet<>(cityRepository.findAll());
    }

    @Override
    public City update(Long id, City city) {
       City foundCity = cityRepository.getById(id);
       City updateCity = City.builder()
               .id(foundCity.getId())
               .name(city.getName())
               .postCode(city.getPostCode())
               .build();

       return cityRepository.save(updateCity);
    }

    @Override
    public City delete(Long id) {
    cityRepository.deleteById(id);
        return null;
    }

    @Override
    public void delete(String name) {
    City city = cityRepository.findByName(name).orElseThrow(IllegalAccessError::new);

    cityRepository.findByName(city.getName());

    }
}
