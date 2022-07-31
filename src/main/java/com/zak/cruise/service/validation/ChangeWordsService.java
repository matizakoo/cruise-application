package com.zak.cruise.service.validation;

import org.springframework.stereotype.Service;

@Service
public class ChangeWordsService {
    public String changeLogin(String login){
        return login.toLowerCase();
    }

    public String changeName(String name){
        String temp = name.toLowerCase();
        if(temp.length() > 1)
            temp = temp.substring(0,1).toUpperCase() + temp.substring(1).toLowerCase();
        return temp;
    }

    public String changeSurname(String surname){
        String temp = surname.toLowerCase();
        if(temp.length() > 1)
            temp = temp.substring(0,1).toUpperCase() + temp.substring(1).toLowerCase();
        return temp;
    }

    public String changeCountry(String country){
        String temp = country.toLowerCase();
        if(temp.length() > 1)
            temp = temp.substring(0,1).toUpperCase() + temp.substring(1).toLowerCase();
        return temp;
    }

    public String changeCity(String country){
        String temp = country.toLowerCase();
        if(temp.length() > 1)
            temp = temp.substring(0,1).toUpperCase() + temp.substring(1).toLowerCase();
        return temp;
    }
}
