package com.zak.cruise.controller;

import com.zak.cruise.dto.LoginCredentialsDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController2 {
    @PostMapping("/loginx")
    public void login(LoginCredentialsDto credentials) {

    }
}