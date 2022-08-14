package com.zak.cruise.service.impl;

import com.zak.cruise.dto.CruiseDTO;
import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Orders;
import com.zak.cruise.repository.CruiseRepository;
import com.zak.cruise.repository.OrdersRepository;
import com.zak.cruise.repository.RouteRepository;
import com.zak.cruise.repository.ShipRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.*;

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
    @Autowired
    private final OrdersRepository ordersRepository;

    public CruiseService(CruiseRepository cruiseRepository, RouteRepository routeRepository, ShipRepository shipRepository, ModelMapper modelMapper, OrdersRepository ordersRepository) {
        this.cruiseRepository = cruiseRepository;
        this.routeRepository = routeRepository;
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.ordersRepository = ordersRepository;
    }

    public List<Cruise> findAllCruises() {
        return (List<Cruise>) cruiseRepository.findAll();
    }

    public List<Cruise> findAllCurrentCruises(){
        List<Cruise> cruiseList = cruiseRepository.findAllCurrentCruises();
        List<Cruise> freeSeatsList = new ArrayList<>();
        for(Cruise e : cruiseList) {
            Integer countFreeSeats = ordersRepository.getNumberOfFreeSeats(e.getId());
            if (countFreeSeats == null)
                freeSeatsList.add(e);
            else {
                if (countFreeSeats < e.getNumberOfSeats()) {
                    freeSeatsList.add(e);
                }
            }
        }
        return freeSeatsList;
    }

    public List<Cruise> findAllFilter(List<Cruise> list){
        List<Cruise> freeSeatsList = new ArrayList<>();
        for(Cruise e : list) {
            Integer countFreeSeats = ordersRepository.getNumberOfFreeSeats(e.getId());
            if (countFreeSeats == null)
                freeSeatsList.add(e);
            else {
                if (countFreeSeats < e.getNumberOfSeats()) {
                    freeSeatsList.add(e);
                }
            }
        }
        return freeSeatsList;
    }

    public List<Cruise> findAllCruisesByDateASC(){
        return findAllFilter((List<Cruise>) cruiseRepository.findAll(Sort.by(Sort.Direction.ASC, "date")));
    }

    public List<Cruise> findAllByCostASC(){
        return findAllFilter((List<Cruise>) cruiseRepository.findAll(Sort.by(Sort.Direction.ASC, "cost")));
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

    public void addCruiseService(CruiseDTO cruiseDTO, BindingResult bindingResult){
        if(cruiseDTO.getCost() == null)
            bindingResult.addError(new FieldError("cruiseDTO", "cost", "Cannot be null"));
        if(cruiseDTO.getDate() == null)
            bindingResult.addError(new FieldError("cruiseDTO", "date", "Invalid date"));
        if(cruiseDTO.getDuration()<1 || cruiseDTO.getDuration() == null)
            bindingResult.addError(new FieldError("cruiseDTO", "duration", "Invalid duration"));
        if(cruiseDTO.getNameOfCruise() == null)
            bindingResult.addError(new FieldError("cruiseDTO", "nameOfCruise", "Invalid nameOfCruise"));
        if(cruiseDTO.getNumberOfSeats() == null || cruiseDTO.getNumberOfSeats() < 1)
            bindingResult.addError(new FieldError("cruiseDTO", "numberOfSeats", "Invalid number of seats"));
        if(!routeRepository.existsById((long) cruiseDTO.getShip()))
            bindingResult.addError(new FieldError("cruiseDTO", "route", "Invalid route. Route probably doesn't exists"));
        if(!shipRepository.existsById((long) cruiseDTO.getShip()))
            bindingResult.addError(new FieldError("cruiseDTO", "ship", "Invalid ship. Ship probably doesn't exists"));
        if(cruiseDTO.getTime() == null)
            bindingResult.addError(new FieldError("cruiseDTO", "time", "Invalid time"));
    }
}
