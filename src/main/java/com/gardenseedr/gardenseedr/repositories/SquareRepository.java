package com.gardenseedr.gardenseedr.repositories;

import com.gardenseedr.gardenseedr.models.Square;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface SquareRepository extends JpaRepository<Square, Long> {
    @Query("SELECT squares.last_watered FROM Square squares")
    public LocalDate getLastWatered();
}
