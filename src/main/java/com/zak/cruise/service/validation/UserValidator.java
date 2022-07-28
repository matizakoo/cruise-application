//package com.zak.cruise.service.validation;
//
//import com.zak.cruise.entity.User;
//import com.zak.cruise.service.Exception.*;
//import org.springframework.jmx.export.metadata.ManagedAttribute;
//import org.springframework.stereotype.Service;
//
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//
//public class UserValidator implements ValidationService{
//    public void validatorInitalizer(User user) {
//        UserValidator userValidator = new UserValidator();
//        userValidator.checkName(user.getName());
//        userValidator.checkSurname(user.getSurname());
//        userValidator.checkPassowrd(user.getPassowrd(), user.getRepeatPassword());
//        userValidator.checkEmail(user.getEmail());
//        userValidator.checkLogin(user.getLogin());
//        userValidator.checkPhoneNumber(user.getPhoneNumber());
//        userValidator.checkZipCodeFormat(user.getZipCode());
//        userValidator.checkCountry(user.getCountry());
//        userValidator.checkCity(user.getCity());
//    }
//    Regex regex;
//    Pattern pattern;
//    Matcher matcher;
//
//    @Override
//    public void checkName(String name) {
//        if(name.length()==0)
//            throw new BadNameException();
//    }
//
//    @Override
//    public void checkSurname(String surname) {
//        if(surname.length()==0)
//            throw new BadSurnameException();
//    }
//
//    @Override
//    public void checkPassowrd(String password, String passwordRepeat) {
//        try{
//            if(!password.equals(passwordRepeat) || validatePassword(password))
//                throw new BadPasswordException();
//        }catch (BadPasswordException e){
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public boolean validatePassword(String password) {
//        pattern = Pattern.compile(regex.passwordValidation);
//        matcher = pattern.matcher(password);
//        return matcher.matches();
//    }
//
//    @Override
//    public void checkLogin(String login) {
//        pattern = Pattern.compile(regex.loginValidation);
//        matcher = pattern.matcher(login);
//        if(!matcher.matches())
//            throw new BadLoginException();
//    }
//
//    @Override
//    public void checkEmail(String email) {
//        pattern = Pattern.compile(regex.emailValidation);
//        matcher = pattern.matcher(email);
//        if(!matcher.matches())
//            throw new BadEmailException();
//    }
//
//    @Override
//    public void checkZipCodeFormat(String zipCode) {
//        pattern = Pattern.compile(regex.zipCodeValidation);
//        matcher = pattern.matcher(zipCode);
//        if(!matcher.matches())
//            throw new BadZipcodeException();
//    }
//
//    @Override
//    public void checkPhoneNumber(String phoneNumber) {
//        pattern = Pattern.compile(regex.phoneNumberValidation);
//        matcher = pattern.matcher(phoneNumber);
//        if(!matcher.matches())
//            throw new BadPhoneNumberException();
//    }
//
//    @Override
//    public void checkCountry(String country) {
//        if(country.length() < 4)
//            throw new BadCountryException();
//    }
//
//    @Override
//    public void checkCity(String city) {
//        if(city.length()==0)
//            throw new BadCityException();
//    }
//
//
//}
