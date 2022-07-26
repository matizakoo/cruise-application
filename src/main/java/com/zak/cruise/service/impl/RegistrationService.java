package com.zak.cruise.service.impl;

import com.zak.cruise.entity.User;
import com.zak.cruise.service.RegisterService;
import com.zak.cruise.service.validation.UserValidator;

public class RegistrationService implements RegisterService {
    @Override
    public void register(User user) {
        validatorInitalizer(user);
        System.out.println("check");
    }

    @Override
    public void login(String login, String password) {

    }

    @Override
    public void validatorInitalizer(User user) {
        UserValidator userValidator = new UserValidator();
        userValidator.checkName(user.getName());
        userValidator.checkSurname(user.getSurname());
        userValidator.checkPassowrd(user.getPassowrd(), user.getRepeatPassword());
        userValidator.checkEmail(user.getEmail());
        userValidator.checkLogin(user.getLogin());
        userValidator.checkPhoneNumber(user.getPhoneNumber());
        userValidator.checkZipCodeFormat(user.getZipCode());
        userValidator.checkCountry(user.getCountry());
        userValidator.checkCity(user.getCity());
    }
}
