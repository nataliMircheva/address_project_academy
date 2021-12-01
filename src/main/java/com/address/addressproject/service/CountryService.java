package com.address.addressproject.service;

import com.address.addressproject.entity.Country;

import java.util.Set;

public interface CountryService {

    Country save (Country country);

    Country findById (Long id);

    Set <Country> findAll();

    Country update (Long id, Country country);

    Country delete(Long id);

    void delete (String name);
}
