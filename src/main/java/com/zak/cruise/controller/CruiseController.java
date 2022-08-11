package com.zak.cruise.controller;

import com.zak.cruise.dto.CruiseDTO;
import com.zak.cruise.entity.Cruise;
import com.zak.cruise.service.impl.CruiseService;
import com.zak.cruise.service.impl.OrdersService;
import com.zak.cruise.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CruiseController {
    Logger logger = LoggerFactory.getLogger("Cruise controller");
    @Autowired
    private CruiseService cruiseService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrdersService orderService;

    public CruiseController() {
    }

    public CruiseController(CruiseService cruiseService, UserService userService, OrdersService orderService) {
        this.cruiseService = cruiseService;
        this.userService = userService;
        this.orderService = orderService;
    }

    @GetMapping("/cruise")
    public String showAll(Model model) {
//        List<Cruise> cruise = cruiseService.findAllCruises();
        List<Cruise> cruise = cruiseService.findAllCurrentCruises();
        final String currentLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isPhotoIncluded = userService.isPhotoSet(currentLogin);
        model.addAttribute("cruises", cruise);
        model.addAttribute("isPhotoIncluded", isPhotoIncluded);
        return "cruise";
    }

    @PostMapping("orderByDateASC")
    public String showAllByDateASC(Model model){
        logger.info("Ordering date ASC");
        List<Cruise> cruise = cruiseService.findAllCruisesByDateASC();
        model.addAttribute("cruises", cruise);
        final String currentLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isPhotoIncluded = userService.isPhotoSet(currentLogin);
        model.addAttribute("isPhotoIncluded", isPhotoIncluded);
        return "cruise";
    }

    @PostMapping("orderByCostASC")
    public String showAllByCostASC(Model model){
        logger.info("Ordering cost ASC");
        List<Cruise> cruise = cruiseService.findAllByCostASC();
        model.addAttribute("cruises", cruise);
        final String currentLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        boolean isPhotoIncluded = userService.isPhotoSet(currentLogin);
        model.addAttribute("isPhotoIncluded", isPhotoIncluded);
        return "cruise";
    }

    @PostMapping(value = "/makeOrder")
    public String order(@RequestParam(name = "cruiseid", required = false) Long id, RedirectAttributes redirectAttributes){
        final String currentLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        orderService.save(id, currentLogin);
        redirectAttributes.addFlashAttribute("message", "Better pack. The journey of a lifetime soon");
        return "redirect:/cruise";
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
