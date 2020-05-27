package com.gardenseedr.gardenseedr.repositories;

import com.gardenseedr.gardenseedr.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository {
    User findByUsername(String username);
}
