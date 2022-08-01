package com.zak.cruise.controller;

import com.zak.cruise.dto.UserDTO;
import com.zak.cruise.dto.UserLoginDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(@ModelAttribute UserLoginDTO userLoginDTO, Model model){
        model.addAttribute("userDTO", userLoginDTO);
        Logger logger = LoggerFactory.getLogger("Connects with /index");
        logger.info("connected with /index");
        return "index";
    }
}