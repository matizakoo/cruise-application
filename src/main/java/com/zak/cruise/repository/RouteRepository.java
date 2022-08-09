package com.zak.cruise.repository;

import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Route> findById(Long id);
}
