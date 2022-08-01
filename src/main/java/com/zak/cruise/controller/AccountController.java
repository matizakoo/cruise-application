package com.zak.cruise.controller;

import com.zak.cruise.dto.UserDTO;
import com.zak.cruise.entity.User;
import com.zak.cruise.repository.UserRepository;
import com.zak.cruise.service.impl.UserService;
import com.zak.cruise.service.validation.UserValidator;
import lombok.extern.log4j.Log4j;
import org.modelmapper.ModelMapper;
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
import java.util.Optional;

@Controller
public class AccountController {
    private final UserService userService;
    @Autowired
    UserRepository userRepository;

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
        return "register";
    }

//    @PostMapping("/register")
    @PostMapping("/register")
    public String save(@Valid UserDTO userDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        Logger logger = LoggerFactory.getLogger("Connects with /register");
        logger.info("Tries to register user " + userDTO.toString());
        UserValidator userValidator = new UserValidator();

        if(userRepository.findByLogin(userDTO.getLogin()) != 0 || !userValidator.checkLogin(userDTO.getLogin())){
            logger.info("logger faild login " + userDTO.getLogin());
            if(!userValidator.checkLogin(userDTO.getLogin())){
                bindingResult.addError(new FieldError("userDTO", "login", "Invalid login"));
            }else {
                bindingResult.addError(new FieldError("userDTO", "login", "Login already exists"));
            }
        }

        //check if password is valid SUCCESS!!:)
        if(userDTO.getPassword()==null || !userValidator.validatePassword(userDTO.getPassword())) {
            logger.info("logger faild password " + userDTO.getPassword());
            bindingResult.addError(new FieldError("userDTO", "password",
                    "Invalid password"));
        }

        if(userDTO.getName() == null){
            logger.info("logger faild name " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "name",
                    "Invalid name"));
        }

        if(userDTO.getSurname() == null){
            logger.info("logger faild surname " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "surname",
                    "Invalid surname"));
        }

        if(userRepository.findByEmail(userDTO.getEmail()) != 0 || !userValidator.checkEmail(userDTO.getEmail())){
            logger.info("logger faild email " + userDTO.getLogin());
            if(!userValidator.checkEmail(userDTO.getEmail())){
                bindingResult.addError(new FieldError("userDTO", "email", "Invalid email"));
            }else{
                bindingResult.addError(new FieldError("userDTO", "email", "Email already exists"));
            }
        }

        if(!userValidator.checkPhoneNumber(userDTO.getPhoneNumber())){
            logger.info("logger faild phone number " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "phoneNumber", "Invalid phone number"));
        }

        if(userDTO.getCountry() == null || userDTO.getCountry().length() < 4){
            logger.info("logger faild country " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "country",
                    "Invalid country"));
        }

        if(userDTO.getCity() == null){
            logger.info("logger faild city " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "city",
                    "Invalid city"));
        }

        if(userDTO.getAddress() == null){
            logger.info("logger faild address " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "address",
                    "Invalid address"));
        }

        if(!userValidator.checkZipCodeFormat(userDTO.getZipCode())){
            logger.info("logger faild zip code " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "zipCode",
                    "Invalid zipCode"));
        }

        if(!userValidator.checkDocumentId(userDTO.getDocumentId())){
            logger.info("logger faild document id " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "documentId",
                    "Invalid documentId"));
        }

        if(bindingResult.hasErrors()){
            logger.info("Registering faild ");
            return "register";
        }
//        redirectAttributes.addFlashAttribute("message", "Succes!");

        userService.register(userDTO);
        return "loginx";
    }
}
