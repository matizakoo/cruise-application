package com.zak.cruise.controller;

import com.zak.cruise.dto.UserDTO;
import com.zak.cruise.service.impl.UserService;
import com.zak.cruise.service.validation.UserValidator;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class AccountController {
    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final UserService userService;

    @Autowired
    public AccountController(UserService userService){
        this.userService = userService;
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
        return "register.html";
    }

//    @PostMapping("/register")
    @PostMapping("/register")
    public String save(@Valid UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        Logger logger = LoggerFactory.getLogger("Connects with /register");
        logger.info("connected with /register xxx");
        UserValidator userValidator = new UserValidator();
        //check if email already exists
//        if(userService.userExists(userDTO.getEmail())){
//            bindingResult.addError(new FieldError("userDTO", "email",
//                    "User already exist"));
//        }

        //check if password is valid
//        if(userValidator.validatePassword(userDTO.getPassword())){
//                bindingResult.addError(new FieldError("userDTO", "password",
//                        "Password is incorrect"));
//        }

        if(bindingResult.hasErrors()){
            return "register";
        }
        redirectAttributes.addFlashAttribute("message", "Succes!");
        logger.info("Registered!!!");
        userService.register(userDTO);
        return "redirect:/login";
    }
}
