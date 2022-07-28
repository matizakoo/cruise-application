package com.zak.cruise.service.validation;

public interface ValidationService {
    void checkName(String name);
    void checkSurname(String surname);
    void checkPassowrd(String password, String passwordRepeat);
    boolean validatePassword(String password);
    void checkLogin(String login);
    void checkEmail(String email);
    void checkZipCodeFormat(String zipCode);
    void checkPhoneNumber(String phoneNumber);
    void checkCountry(String country);
    void checkCity(String city);
}