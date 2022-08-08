package com.zak.cruise.service.impl;

import com.zak.cruise.entity.Cruise;
import com.zak.cruise.repository.CruiseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CruiseService {
    @Autowired
    CruiseRepository cruiseRepository;

    public CruiseService(CruiseRepository cruiseRepository) {
        this.cruiseRepository = cruiseRepository;
    }

    public List<Cruise> findAllCruises() {
        return (List<Cruise>) cruiseRepository.findAll();
    }

    public Cruise getCruiseDetails(Long id){
        Optional<Cruise> cruiseResponse = cruiseRepository.findById(id);
        return cruiseResponse.get();
    }
}
