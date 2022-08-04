//package com.zak.cruise.service.impl;
//
//import com.zak.cruise.repository.UserRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService {
//    @Autowired
//    private UserRepository userRepository;
//    Logger logger = LoggerFactory.getLogger("User details");
//    @Autowired
//    private DelegatingPasswordEncoder passwordEncoder;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws IllegalArgumentException{
//        final com.zak.cruise.entity.User user = userRepository.findByEmail(username);
//        if(user==null){
//            logger.info("User is null");
//            throw new IllegalArgumentException("x");
//        }
//        UserDetails userDetails = org.springframework.security.core.userdetails.User.withUsername(user.getEmail())
//                .password(passwordEncoder.encode(user.getPassword())).authorities("USER").build();
//        logger.info("success!");
//        return userDetails;
//    }
//}