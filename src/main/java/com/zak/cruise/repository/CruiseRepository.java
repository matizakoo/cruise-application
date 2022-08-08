package com.zak.cruise.repository;

import com.zak.cruise.entity.Cruise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Long> {
    Optional<Cruise> findById(Long id);
}
