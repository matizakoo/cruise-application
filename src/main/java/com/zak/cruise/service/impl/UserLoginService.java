//package com.zak.cruise.service.impl;
//
//import com.zak.cruise.entity.UserLogin;
//import com.zak.cruise.repository.LoginRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Optional;
//
//@Service
//public class UserLoginService {
//    private final LoginRepository loginRepository;
//    private final ModelMapper modelMapper;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//
//    @Autowired
//    public UserLoginService(LoginRepository loginRepository, ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder) {
//        this.loginRepository = loginRepository;
//        this.modelMapper = modelMapper;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public boolean verifyData(ArrayList<UserLogin> userLogin, ArrayList<UserLogin> userPassword){
//        if(userLogin.get(0) == userPassword.get(0))
//            return true;
//        else
//            return false;
//    }
//}
