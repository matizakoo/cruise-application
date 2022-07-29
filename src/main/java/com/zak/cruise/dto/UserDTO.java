package com.zak.cruise.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.stereotype.Controller;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
@Controller
@Getter
@Setter
public class UserDTO {
    @NotBlank(message = "Enter your name")
    private String name;
    @NotBlank(message = "Enter your surname")
    private String surname;
    @NotBlank(message = "Enter your password")
//    @Length(min = 8, max = 20, message = "Password must be valid and at least 8 and max 20 chars")
    private String password;
    @NotBlank(message = "Enter your email")
    @Email(message = "Enter valid email")
    private String email;
    @NotBlank(message = "Enter your phone number")
    @Length(min = 9, message = "At least 9 symbols")
    private String phoneNumber;
    @NotBlank(message = "Enter your country")
    private String country;
    @NotBlank(message = "Enter your city")
    private String city;
    @NotBlank(message = "Enter your address")
    private String address;
    @NotBlank(message = "Enter your zipcode")
    private String zipCode;
    @NotBlank(message = "Enter your login")
    private String login;
    private String formError;
    private String documentId;
    private Long role = Long.valueOf(1);
    public UserDTO() {
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", address='" + address + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", login='" + login + '\'' +
                ", formError='" + formError + '\'' +
                ", documentId='" + documentId + '\'' +
                '}';
    }
}
