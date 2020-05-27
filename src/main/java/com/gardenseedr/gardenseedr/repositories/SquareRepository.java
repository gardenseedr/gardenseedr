package com.gardenseedr.gardenseedr.repositories;

import com.gardenseedr.gardenseedr.models.Square;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SquareRepository extends JpaRepository<Square, Long> {
}
