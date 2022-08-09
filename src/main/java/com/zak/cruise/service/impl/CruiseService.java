package com.zak.cruise.service.impl;

import com.zak.cruise.dto.CruiseDTO;
import com.zak.cruise.entity.Cruise;
import com.zak.cruise.repository.CruiseRepository;
import com.zak.cruise.repository.RouteRepository;
import com.zak.cruise.repository.ShipRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CruiseService {
    Logger logger = LoggerFactory.getLogger("Cruise service");
    @Autowired
    CruiseRepository cruiseRepository;
    @Autowired
    private final RouteRepository routeRepository;
    @Autowired
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;

    public CruiseService(CruiseRepository cruiseRepository, RouteRepository repository, RouteRepository routeRepository, ShipRepository shipRepository, ModelMapper modelMapper) {
        this.cruiseRepository = cruiseRepository;
        this.routeRepository = routeRepository;
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
    }

    public List<Cruise> findAllCruises() {
        return (List<Cruise>) cruiseRepository.findAll();
    }

    public Cruise getCruiseDetails(Long id){
        Optional<Cruise> cruiseResponse = cruiseRepository.findById(id);
        return cruiseResponse.get();
    }

    @Transactional
    public Cruise save(Cruise cruise){
        return cruiseRepository.save(cruise);
    }

    public Cruise addNewCruise(CruiseDTO cruiseDTO){
        Cruise cruise = new Cruise();
        LocalDate localDate = LocalDate.of(cruiseDTO.getDate().getYear(), cruiseDTO.getDate().getMonthValue(), cruiseDTO.getDate().getDayOfMonth());
        cruiseDTO.setDate(localDate);
        cruise.setRoute(routeRepository.findById((long) cruiseDTO.getRoute()).get());
        cruise.setShip(shipRepository.findById((long) cruiseDTO.getShip()).get());
        modelMapper.map(cruiseDTO, cruise);

        return save(cruise);
    }
}
