package com.zak.cruise.dto;

import com.zak.cruise.entity.Role;
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
    private Long id;
    private String username;
    private String surname;
    private String email;
    private String phoneNumber;
    private String country;
    private String city;
    private String address;
    private String zipCode;
    private String documentId;
    private String password;
    private String login;
    private String formError;
    public UserDTO() {
    }

    public UserDTO(String username, String surname, String email, String phoneNumber, String country, String city, String address, String zipCode, String documentId, String password, String login) {
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.documentId = documentId;
        this.password = password;
        this.login = login;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "name='" + username + '\'' +
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
