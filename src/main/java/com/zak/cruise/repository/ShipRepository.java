package com.zak.cruise.repository;

import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShipRepository extends JpaRepository<Ship, Long> {
    Optional<Ship> findById(Long id);
}
