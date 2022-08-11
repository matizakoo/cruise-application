package com.zak.cruise.service.validation;

import com.zak.cruise.dto.CruiseDTO;
import com.zak.cruise.dto.UserDTO;
import com.zak.cruise.entity.User;
import com.zak.cruise.repository.UserRepository;
import com.zak.cruise.service.Exception.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.metadata.ManagedAttribute;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UserValidator implements ValidationService{
    @Autowired
    UserRepository userRepository;
    Logger logger = LoggerFactory.getLogger("validation");
    private Regex regex = new Regex();
    private Pattern pattern;
    private Matcher matcher;

    public UserValidator() {
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

    public void validation(UserDTO userDTO, BindingResult bindingResult){
        if(userRepository.findByLogin(userDTO.getLogin()).isPresent() || !checkLogin(userDTO.getLogin())){
            logger.info("logger faild login " + userDTO.getLogin());
            if(!checkLogin(userDTO.getLogin())){
                bindingResult.addError(new FieldError("userDTO", "login", "Invalid login"));
            }else {
                bindingResult.addError(new FieldError("userDTO", "login", "Login already exists"));
            }
        }

        //change username -> login
        if(userDTO.getUsername() == null){
            logger.info("logger faild name " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "username",
                    "Invalid name"));
        }

        //check if password is valid SUCCESS!!:)
        if(userDTO.getPassword()==null || !validatePassword(userDTO.getPassword())) {
            logger.info("logger faild password " + userDTO.getPassword());
            bindingResult.addError(new FieldError("userDTO", "password",
                    "Invalid password"));
        }

        if(userDTO.getSurname() == null){
            logger.info("logger faild surname " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "surname",
                    "Invalid surname"));
        }

        if(userRepository.findByEmailz(userDTO.getEmail()) != 0 || !checkEmail(userDTO.getEmail())){
            logger.info("logger faild email " + userDTO.getLogin());
            if(!checkEmail(userDTO.getEmail())){
                bindingResult.addError(new FieldError("userDTO", "email", "Invalid email"));
            }else{
                bindingResult.addError(new FieldError("userDTO", "email", "Email already exists"));
            }
        }

        if(!checkPhoneNumber(userDTO.getPhoneNumber())){
            logger.info("logger faild phone number " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "phoneNumber", "Invalid phone number"));
        }

        if(userDTO.getCountry() == null || userDTO.getCountry().length() < 4){
            logger.info("logger faild country " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "country",
                    "Invalid country"));
        }

        if(userDTO.getCity() == null){
            logger.info("logger faild city " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "city",
                    "Invalid city"));
        }

        if(userDTO.getAddress() == null){
            logger.info("logger faild address " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "address",
                    "Invalid address"));
        }

        if(!checkZipCodeFormat(userDTO.getZipCode())){
            logger.info("logger faild zip code " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "zipCode",
                    "Invalid zipCode"));
        }

        if(!checkDocumentId(userDTO.getDocumentId())){
            logger.info("logger faild document id " + userDTO.getLogin());
            bindingResult.addError(new FieldError("userDTO", "documentId",
                    "Invalid documentId"));
        }
    }
}
