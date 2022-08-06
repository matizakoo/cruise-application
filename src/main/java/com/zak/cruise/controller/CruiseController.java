package com.zak.cruise.controller;

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
import org.springframework.web.bind.annotation.PostMapping;

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

    @PostMapping("/makeOrder")
    public String order(/*Model or sth mozna tez wyjebac cruise i model, cos tam roman mowil*/Cruise cruise, User user, Model model /*, BindingResult bindingResult*/){
        //model get by cruise name / id
        user = userRepository.findByEmail("zegar@wp.pl");
        logger.info(""+cruise.getId());
//        Cruise cruise = new Cruise();
        ModelMapper modelMapper = new ModelMapper();
        logger.info(cruise.toString());
        logger.info(user.toString());
        Order order = new Order(cruise, new Status(), user);
        orderRepository.save(order);
        return "index";
    }
}
