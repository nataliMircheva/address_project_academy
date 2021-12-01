package com.address.addressproject.service.impl;

import com.address.addressproject.entity.Country;
import com.address.addressproject.repository.CountryRepository;
import com.address.addressproject.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }



    @Override
    public Country save(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country findById(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(String.format("Not found city with this id: %d", id)));
    }

    @Override
    public Set<Country> findAll() {
        return new HashSet<>(countryRepository.findAll());
    }

    @Override
    public Country update(Long id, Country country) {
        Country foundCountry = countryRepository.getById(id);
        Country updateCountry = Country.builder()
                .id(foundCountry.getId())
                .name(country.getName())
                .code_Alpha2(country.getCode_Alpha2())
                .build();
        return countryRepository.save(updateCountry);
    }

    @Override
    public Country delete(Long id) {
    countryRepository.deleteById(id);
        return null;
    }

    @Override
    public void delete(String name) {
        Country country = countryRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        countryRepository.deleteByName(country.getName());

    }
}
