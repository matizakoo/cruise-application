package com.zak.cruise.repository;

import com.zak.cruise.entity.Cruise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CruiseRepository extends JpaRepository<Cruise, Long> {
    Optional<Cruise> findById(Long id);

    @Query("select a from Cruise a where a.date >= CURRENT_DATE")
    List<Cruise> findAllCurrentCruises();
}
