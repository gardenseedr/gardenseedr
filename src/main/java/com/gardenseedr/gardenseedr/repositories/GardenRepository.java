package com.gardenseedr.gardenseedr.repositories;

import com.gardenseedr.gardenseedr.models.Garden;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GardenRepository extends JpaRepository<Garden, Long> {
}
