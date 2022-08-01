package com.zak.cruise.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

@Controller
@Getter
@Setter
public class UserLoginDTO {
    private String login;
    private String password;
    private String formError;

    public UserLoginDTO() {
    }

    public UserLoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{" +
                "login='" + login + '\'' +
                '}';
    }
}
