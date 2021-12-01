package com.address.addressproject.service.impl;

import com.address.addressproject.entity.Neighborhood;
import com.address.addressproject.repository.NeighborhoodRepository;
import com.address.addressproject.service.NeighborhoodService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class NeighborhoodServiceImpl implements NeighborhoodService {

    private final NeighborhoodRepository neighborhoodRepository;

    public NeighborhoodServiceImpl (NeighborhoodRepository neighborhoodRepository){
        this.neighborhoodRepository = neighborhoodRepository;
    }


    @Override
    public Neighborhood save(Neighborhood neighborhood) {
        return neighborhoodRepository.save(neighborhood);
    }

    @Override
    public Neighborhood findById(Long id) {
        return neighborhoodRepository.findById(id).orElseThrow(() -> new IllegalArgumentException( String.format(" Not found neighborhood with this id: %d", id)));
    }

    @Override
    public Set<Neighborhood> findAll() {
        return new HashSet<>(neighborhoodRepository.findAll());
    }

    @Override
    public Neighborhood update(Long id, Neighborhood neighborhood) {
        Neighborhood foundNeighborhood = neighborhoodRepository.getById(id);
        Neighborhood updateNeighborhood = Neighborhood.builder()
                .id(foundNeighborhood.getId())
                .name(neighborhood.getName())
                .build();

        return neighborhoodRepository.save(updateNeighborhood);
    }

    @Override
    public Neighborhood delete(Long id) {
    neighborhoodRepository.deleteById(id);
        return null;
    }

    @Override
    public void delete(String name) {

        Neighborhood neighborhood = neighborhoodRepository.findByName(name).orElseThrow(IllegalArgumentException::new);
        neighborhoodRepository.deleteByName(name);

    }
}
