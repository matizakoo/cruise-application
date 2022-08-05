package com.zak.cruise.controller;

import com.zak.cruise.dto.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserProfileController {
    Logger logger = LoggerFactory.getLogger("Profile checker B)");
    @GetMapping("profile")
    public String getUserProfile(@ModelAttribute("userDTO") UserDTO userDTO, Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("username", userDTO.getUsername());
        return "profile";
    }
}
