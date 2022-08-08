package com.zak.cruise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zak.cruise.dto.CruiseDTO;
import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Order;
import com.zak.cruise.entity.Status;
import com.zak.cruise.entity.User;
import com.zak.cruise.repository.CruiseRepository;
import com.zak.cruise.repository.OrderRepository;
import com.zak.cruise.repository.UserRepository;
import com.zak.cruise.service.impl.CruiseService;
import com.zak.cruise.service.impl.MyUserDetails;
import com.zak.cruise.service.impl.OrderService;
import com.zak.cruise.service.impl.UserService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CruiseController {
    Logger logger = LoggerFactory.getLogger("Cruise controller");
    @Autowired
    private CruiseService cruiseService;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CruiseRepository cruiseRepository;
    @Autowired
    private UserService userService;
    @Autowired
    private OrderService orderService;

    public CruiseController() {
    }

    public CruiseController(CruiseService cruiseService, OrderRepository orderRepository, UserRepository userRepository, CruiseRepository cruiseRepository, UserService userService, OrderService orderService) {
        this.cruiseService = cruiseService;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
        this.cruiseRepository = cruiseRepository;
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/dawaj")
    public String showAll(Model model) {
        List<Cruise> cruise = cruiseService.findAllCruises();
        model.addAttribute("cruises", cruise);
        return "cruise";
    }

//    @PostMapping("/makeOrder")
//    public String order(/*Model or sth mozna tez wyjebac cruise i model, cos tam roman mowil*//*@ModelAttribute Cruise cruise, User user,*/ /*@ModelAttribute Model model*/ /*, BindingResult bindingResult*/){
    @PostMapping(value = "/makeOrder")
//    public String order(@RequestParam(name = "cruise.nameOfCruise", required=false) String model) throws JsonProcessingException {
//    public String order(@ModelAttribute("cruise") Cruise cruise, Model model){ // wersja romana i nawet mi sie podoba
    public String order(@RequestParam(name = "cruiseid", required = false) Long id){
        Cruise cruise = cruiseService.getCruiseDetails(id); //smiga
        Status status = new Status().defaultStatus();
        User user = userService.getUserByDetails("zegar123@wp.pl");
        logger.info("Cruise id: "+cruise.getId());
        logger.info("Status id: "+status.getId());
        logger.info("User id: "+user.getId());
        orderService.save(cruise, status, user);
        return "cruise";
    }
}
