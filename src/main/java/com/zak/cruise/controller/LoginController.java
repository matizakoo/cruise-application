package com.zak.cruise.controller;

import com.nimbusds.jose.proc.SecurityContext;
import com.zak.cruise.dto.LoginCredentialsDto;
import com.zak.cruise.dto.UserDTO;
import com.zak.cruise.dto.UserLoginDTO;
import com.zak.cruise.entity.User;
import com.zak.cruise.repository.UserRepository;
//import com.zak.cruise.service.impl.UserDetailServiceImpl;
import org.hibernate.Cache;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger("Connects with /login");
//    @Autowired
//    private DelegatingPasswordEncoder passwordEncoder;
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder){
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
    @GetMapping("/loginx")
    public String login(@ModelAttribute LoginCredentialsDto credentials, Model model){
        model.addAttribute("credentials", credentials);
        logger.info("Connected with /loginx getmapping");
        return "loginx";
    }

//    @PostMapping("/loginx")
//    public String loginUser(@Valid UserDTO userDTO, BindingResult bindingResult,Model model, HttpServletRequest request, HttpSession session/*, RedirectAttributes redirectAttributes*/){
//        logger.info(userDTO.getLogin());
//        Optional<User> user = userRepository.findByLogin(userDTO.getLogin());
//        logger.info(user.toString());
//        try {
//            if(user==null){
//                logger.info("User is null");
//                throw new IllegalArgumentException("x");
//            }
//            logger.info("go with it!");
////            UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
////                    .password(passwordEncoder.encode(user.getPassword())).authorities("USER").build();
//        }catch (IllegalArgumentException e){
//            bindingResult.addError(new FieldError("userDTO", "password",
//                    "Invalid login data"));
//            e.printStackTrace();
//            return "loginx";
//        }
//        logger.info("Data is correct");
//        return "profile";
//    }
}

