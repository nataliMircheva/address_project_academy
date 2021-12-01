package com.address.addressproject.controller;

import com.address.addressproject.entity.Neighborhood;
import com.address.addressproject.service.NeighborhoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class NeighborhoodController {
    @Autowired
    private NeighborhoodService neighborhoodService;

    public NeighborhoodController (NeighborhoodService neighborhoodService) {
        this.neighborhoodService = neighborhoodService;
    }
        @GetMapping(value = "/neighborhoods")
    public Set<Neighborhood> findNeighborhoods (){
        return neighborhoodService.findAll();
        }

        @PostMapping (value = "/save/neighborhood")
    public Neighborhood save (@RequestBody Neighborhood neighborhood){
        return neighborhoodService.save(neighborhood);
        }

        @DeleteMapping(value = "/delete/neighborhood/{id}")
        public Neighborhood delete (@PathVariable Long id){
        return neighborhoodService.delete(id);
        }


    }

