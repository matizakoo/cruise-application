package com.zak.cruise.controller;

import com.zak.cruise.dto.UserDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

public class LoginController {
    @GetMapping("/login")
    public String login(@ModelAttribute UserDTO userDTO, Model model){
        model.addAttribute("userDTO", userDTO);
        return "login";
    }
}
