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
    Logger logger = LoggerFactory.getLogger("validation");
    private Regex regex = new Regex();
    private Pattern pattern;
    private Matcher matcher;

    @Override
    public boolean checkName(String name) {
        logger.info("Tries to validate name");
        if(name == null)
            return false;
        return name!=null && name.length() > 0;
    }

    @Override
    public boolean checkSurname(String surname) {
        logger.info("Tries to validate surname");
        if(surname == null)
            return false;
        return surname.length() > 0;
    }

    @Override
    public boolean validatePassword(String password) {
        logger.info("Tries to validate password");
        pattern = Pattern.compile(regex.passwordValidation);
        matcher = pattern.matcher(password);
        return matcher.matches(); //todo: check it
    }

    @Override
    public boolean checkLogin(String login) {
        logger.info("Tries to validate login");
        if(login == null)
            return false;
        pattern = Pattern.compile(regex.loginValidation);
        matcher = pattern.matcher(login);
        return matcher.matches();
    }

    @Override
    public boolean checkEmail(String email) {
        logger.info("Tries to validate email");
        if(email == null)
            return false;
        pattern = Pattern.compile(regex.emailValidation);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    @Override
    public boolean checkZipCodeFormat(String zipCode) {
        logger.info("Tries to validate zip code");
        if(zipCode == null)
            return false;
        pattern = Pattern.compile(regex.zipCodeValidation);
        matcher = pattern.matcher(zipCode);
        return matcher.matches();
    }

    @Override
    public boolean checkPhoneNumber(String phoneNumber) {
        logger.info("Tries to validate zip code");
        if(phoneNumber == null) {
            return false;
        }
//        return phoneNumber.length() > 9;
        pattern = Pattern.compile(regex.phoneNumberValidation);
        matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }

    @Override
    public boolean checkDocumentId(String documentId) {
        logger.info("Tries to validate document id");
        if(documentId == null) {
            return false;
        }
//        return phoneNumber.length() > 9;
        pattern = Pattern.compile(regex.phoneNumberValidation);
        matcher = pattern.matcher(documentId);
        return matcher.matches();
    }
}
