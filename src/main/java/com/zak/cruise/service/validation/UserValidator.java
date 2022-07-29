package com.zak.cruise.service.validation;

import com.zak.cruise.entity.User;
import com.zak.cruise.service.Exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.metadata.ManagedAttribute;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements ValidationService{
    private Regex regex = new Regex();
    @Override
    public void checkName(String name) {
        if(name.length()==0)
            throw new BadNameException();
    }

    @Override
    public void checkSurname(String surname) {
        if(surname.length()==0)
            throw new BadSurnameException();
    }

    @Override
    public void checkPassowrd(String password, String passwordRepeat) {
        try{
            if(!password.equals(passwordRepeat) || validatePassword(password))
                throw new BadPasswordException();
        }catch (BadPasswordException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean validatePassword(String password) {
        Logger logger = LoggerFactory.getLogger("validate password");
        logger.info("Tries to validate password");
        Pattern pattern = Pattern.compile(regex.passwordValidation);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches(); //todo: check it
    }

    @Override
    public void checkLogin(String login) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex.loginValidation);
        matcher = pattern.matcher(login);
        if(!matcher.matches())
            throw new BadLoginException();
    }

    @Override
    public void checkEmail(String email) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex.emailValidation);
        matcher = pattern.matcher(email);
        if(!matcher.matches())
            throw new BadEmailException();
    }

    @Override
    public void checkZipCodeFormat(String zipCode) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex.zipCodeValidation);
        matcher = pattern.matcher(zipCode);
        if(!matcher.matches())
            throw new BadZipcodeException();
    }

    @Override
    public void checkPhoneNumber(String phoneNumber) {
        Pattern pattern;
        Matcher matcher;
        pattern = Pattern.compile(regex.phoneNumberValidation);
        matcher = pattern.matcher(phoneNumber);
        if(!matcher.matches())
            throw new BadPhoneNumberException();
    }

    @Override
    public void checkCountry(String country) {
        if(country.length() < 4)
            throw new BadCountryException();
    }

    @Override
    public void checkCity(String city) {
        if(city.length()==0)
            throw new BadCityException();
    }


}
