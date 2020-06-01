package com.gardenseedr.gardenseedr.repositories;

import com.gardenseedr.gardenseedr.models.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlantRepository extends JpaRepository<Plant, Long> {
    @Query("SELECT plants.plant_name FROM Plant plants")
    public List<String> getAllPlants();
}
