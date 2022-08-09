package com.zak.cruise.controller;

import com.zak.cruise.dto.CruiseDTO;
import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Status;
import com.zak.cruise.entity.User;
import com.zak.cruise.repository.*;
import com.zak.cruise.service.impl.CruiseService;
import com.zak.cruise.service.impl.OrderService;
import com.zak.cruise.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        final String currentLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        orderService.save(id, currentLogin);
        return "cruise";
    }

    @GetMapping(value = "/addCruise")
    public String getCruise(@ModelAttribute CruiseDTO cruiseDTO,Model model){
        model.addAttribute("cruiseDTO", cruiseDTO);
        return "addCruise";
    }

    @PostMapping(value = "/addCruise")
    public String addCruise(@Valid CruiseDTO cruiseDTO, Model model, BindingResult bindingResult){
        logger.info("Creating new cruise");
//        logger.info("  name : " + cruiseDTO.getNameOfCruise() +
//                "  date : " + cruiseDTO.getDate() +
//                "  time : " + cruiseDTO.getTime() +
//                "  cost : " + cruiseDTO.getCost() +
//                "  duration : " + cruiseDTO.getDuration() +
//                "  route : " + cruiseDTO.getRoute() +
//                "  ship : " + cruiseDTO.getShip());
        cruiseService.addCruiseService(cruiseDTO, bindingResult);
        if(bindingResult.hasErrors()){
            logger.info("Creating new cruise failed");
            return "addCruise";
        }
        cruiseService.addNewCruise(cruiseDTO);
        return "addCruise";
    }
}
