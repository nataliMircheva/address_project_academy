package com.address.addressproject.service;

import com.address.addressproject.entity.Neighborhood;

import java.util.Set;

public interface NeighborhoodService {

    Neighborhood save (Neighborhood neighborhood);

    Neighborhood findById (Long id);

    Set<Neighborhood> findAll ();

    Neighborhood update (Long id, Neighborhood neighborhood);
    Neighborhood delete (Long id);

     void delete (String name);
}
