package com.zak.cruise.service.impl;

import com.zak.cruise.entity.User;
import com.zak.cruise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class UserService {
//    private final UserRepository userRepository;

//    @Autowired
//    public UserService(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }

    @Transactional
    public Optional<User> invalidByEmail(String email){
//        return userRepository.findUserByEmail(email);
        return null;
    }

//    public boolean userExists(String email){
//        return findUserByEmail(email).isPresent();
//    }
}
