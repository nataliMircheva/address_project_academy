package com.address.addressproject.repository;

import com.address.addressproject.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CityRepository extends JpaRepository <City,Long>{

    Optional<City> findByName (String name);
    void deleteByName (String name);
}
