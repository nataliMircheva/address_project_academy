package com.address.addressproject.service;

import com.address.addressproject.entity.City;

import java.util.Set;

public interface CityService {

    City save (City city);

    City findById (Long id);

    Set<City> findAll();


    City update (Long id, City city);

    City delete (Long id);

    void delete (String name);

}
