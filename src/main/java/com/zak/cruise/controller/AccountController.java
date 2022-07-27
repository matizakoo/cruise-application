//package com.zak.cruise.controller;
//
//import com.zak.cruise.dto.UserDTO;
//import com.zak.cruise.service.impl.UserService;
//import lombok.extern.log4j.Log4j;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.propertyeditors.StringTrimmerEditor;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.WebDataBinder;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.InitBinder;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//import javax.validation.Valid;
//
//@Controller
//public class AccountController {
//    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
//    private final UserService userService;
//
//    @Autowired
//    public AccountController(UserService userService){
//        this.userService = userService;
//    }
//
//    @InitBinder
//    public void initBinder(WebDataBinder webDataBinder){
//        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
//        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
//    }
//
//    @GetMapping("/register")
//    public String register(@ModelAttribute UserDTO userDTO, Model model ){
//        model.addAttribute("userDTO", userDTO);
//        return "register";
//    }
//
//    @PostMapping("/register")
//    public String save(@Valid UserDTO userDTO, BindingResult bindingResult){
//        //check if email already exists
//        if(userService.userExists(userDTO.getEmail())){
//            bindingResult.addError(new FieldError("userDTO", "email", "User already exist"));
//        }
//
//        //check if password is valid
//        if(userDTO.getPassword() != null && userDTO.getRepeatPassword() != null){
//            if(!userDTO.getPassword().equals(userDTO.getRepeatPassword())){
//                bindingResult.addError(new FieldError("userDTO", "password", "Password is incorrect"));
//            }
//        }
//
//        if(bindingResult.hasErrors()){
//            return "Register failed";
//        }
//        log.info(">>userDTO : {}", userDTO.toString());
//        return "redirect:/login";
//    }
//}
