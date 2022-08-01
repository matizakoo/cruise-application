package com.zak.cruise.controller;

import com.nimbusds.jose.proc.SecurityContext;
import com.zak.cruise.dto.UserDTO;
import com.zak.cruise.dto.UserLoginDTO;
import com.zak.cruise.repository.UserRepository;
import org.hibernate.Cache;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger("Connects with /login");

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
    public String login(@ModelAttribute UserDTO userDTO, Model model){
        model.addAttribute("userDTO", userDTO);
        logger.info("Connected with /loginx");
        return "loginx";
    }

    @PostMapping("/loginx")
    public String loginUser(@Valid UserDTO userDTO, BindingResult bindingResult,Model model, HttpServletRequest request, HttpSession session/*, RedirectAttributes redirectAttributes*/){
        logger.info(userDTO.getLogin());
//        UserLogin userLogin = new UserLogin();
        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();

        if(userRepository.getIdOfLogin(userDTO.getLogin()) != userRepository.getIdOfpassword(userDTO.getPassword())){
            logger.info("Invalid login data");
            bindingResult.addError(new FieldError("userDTO", "password",
                    "Invalid login data"));
            return "loginx";
        }

        logger.info("Data is correct");
        session.invalidate();
        HttpSession newSession = request.getSession();
        logger.info("new session created: " + newSession.getId());
        model.addAttribute("session", newSession);
        return "profile";
    }

    @PostMapping("/destroy")
    public String destroySession(HttpServletRequest request) {
        request.getSession().invalidate();
        return "index";
    }
}

