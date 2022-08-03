package com.zak.cruise.controller;

import com.zak.cruise.entity.Cruise;
import com.zak.cruise.service.impl.CruiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CruiseController {
    @Autowired
    private CruiseService cruiseService;

    public CruiseController() {
    }

    public CruiseController(CruiseService cruiseService) {
        this.cruiseService = cruiseService;
    }

    @GetMapping("/dawaj")
    public String showAll(Model model) {
        List<Cruise> cruise = cruiseService.findAllCruises();
        model.addAttribute("cruises", cruise);
        return "cruise";
    }
}
