package com.zak.cruise.service.validation;

public interface ValidationService {
    boolean checkName(String name);
    boolean checkSurname(String surname);
    boolean validatePassword(String password);
    boolean checkLogin(String login);
    boolean checkEmail(String email);
    boolean checkZipCodeFormat(String zipCode);
    boolean checkPhoneNumber(String phoneNumber);
    boolean checkCountry(String country);
    boolean checkCity(String city);
    boolean findByEmail(String email);
}