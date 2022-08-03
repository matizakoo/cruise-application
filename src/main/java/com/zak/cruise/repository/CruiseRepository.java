package com.zak.cruise.repository;

import com.zak.cruise.entity.Cruise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Long> {
}
