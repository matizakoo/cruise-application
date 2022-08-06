package com.zak.cruise.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zak.cruise.dto.CruiseDTO;
import com.zak.cruise.entity.Cruise;
import com.zak.cruise.entity.Order;
import com.zak.cruise.entity.Status;
import com.zak.cruise.entity.User;
import com.zak.cruise.repository.OrderRepository;
import com.zak.cruise.repository.UserRepository;
import com.zak.cruise.service.impl.CruiseService;
import com.zak.cruise.service.impl.MyUserDetails;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    public CruiseController() {
    }

    public CruiseController(CruiseService cruiseService, OrderRepository orderRepository, UserRepository userRepository) {
        this.cruiseService = cruiseService;
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
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
    public String order(@RequestParam(name = "cruise.nameOfCruise", required=false) String model) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        CruiseDTO cruiseDTO = mapper.readValue(model, CruiseDTO.class);
        //model get by cruise name / id
//        logger.info("id: "+cruiseDTO.getNameOfCruise());
        logger.info("name of cruise: "+model);
        User user = new User();
        user = userRepository.findByEmail("zegar@wp.pl");
//        logger.info(""+cruiseDTO.getId());
//        Cruise cruise = new Cruise();
        ModelMapper modelMapper = new ModelMapper();
//        logger.info(cruiseDTO.toString());
        logger.info(user.toString());
//        Order order = new Order(cruiseDTO, new Status(), user);
//        orderRepository.save(order);
        return "cruise";
    }
}
