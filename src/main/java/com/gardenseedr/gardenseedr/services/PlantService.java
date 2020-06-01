package com.gardenseedr.gardenseedr.services;

import com.gardenseedr.gardenseedr.models.Plant;

import java.util.List;

public interface PlantService {
    List<Plant> listAllPlants();

    Plant getPlantById(Long id);
}
