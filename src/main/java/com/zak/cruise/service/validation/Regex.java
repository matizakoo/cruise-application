package com.zak.cruise.service.validation;

public class Regex {
    //digit + lower latin + upper latin + punctuation + symbol + 8-20 letters
    //digit + lower latin + upper latin
    public final String passwordValidation = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$";
    // (?=\S+$)  (?=.*[@#$%^&+=])
    //any email
    public final String emailValidation = "^(.+)@(.+)\\.(.+)$";
    //latin + numbers 1-25 chars
    public final String loginValidation = "^[a-z0-9]{1,25}";
    public final String zipCodeValidation = "^[a-zA-Z0-9]{1,15}$";
    public final String phoneNumberValidation ="/\\(?([0-9]{3})\\)?([ .-]?)([0-9]{3})\\2([0-9]{4})/";
}
