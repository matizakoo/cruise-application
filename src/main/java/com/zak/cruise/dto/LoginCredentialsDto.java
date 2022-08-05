package com.zak.cruise.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginCredentialsDto {
    private String username;
    private String password;
    private String formError;
}