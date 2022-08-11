package com.zak.cruise.controller;

import com.zak.cruise.dto.UserDTO;
import com.zak.cruise.repository.UserRepository;
import com.zak.cruise.service.impl.UserService;
import com.zak.cruise.service.validation.UserValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AccountController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserValidator userValidator;

    @Autowired
    public AccountController(){
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/register")
    public String register(@ModelAttribute UserDTO userDTO, Model model){
        model.addAttribute("userDTO", userDTO);
        Logger logger = LoggerFactory.getLogger("Connects with /register");
        logger.info("connected with /register");
        return "register";
    }

//    @PostMapping("/register")
    @PostMapping("/register")
    public String save(@Valid UserDTO userDTO, BindingResult bindingResult){
        Logger logger = LoggerFactory.getLogger("Connects with /register");
        logger.info("Tries to register user " + userDTO.toString());
        userValidator.validation(userDTO, bindingResult);
        if(bindingResult.hasErrors()){
            logger.info("Registering faild ");
            return "register";
        }
        userService.register(userDTO);

        return "redirect:/login";
    }
}
