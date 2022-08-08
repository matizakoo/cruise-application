package com.zak.cruise.controller;

import com.zak.cruise.dto.UserDTO;
import com.zak.cruise.entity.User;
import com.zak.cruise.service.impl.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
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
    @Autowired
    UserService userService;

    @GetMapping("/profile")
    public String getProfile(Model model){
        final String currentLogin = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.getUserDetails(currentLogin).get();
        model.addAttribute("user", user);
        return "profile";
    }
}
