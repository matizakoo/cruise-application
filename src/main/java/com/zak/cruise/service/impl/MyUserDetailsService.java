package com.zak.cruise.service.impl;

import com.zak.cruise.entity.User;
import com.zak.cruise.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {
    Logger logger = LoggerFactory.getLogger("Checking UserDetailsService");
    @Autowired
    UserRepository userRepository;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        logger.info("check it");
        Optional<User> user = userRepository.findByLogin(login);
        user.orElseThrow(() -> new UsernameNotFoundException("Not found"));
        logger.info("ok :)");

        //Integer id, String name, String surname, String email, String phoneNumber, String country, String city,
        // String address, String zipCode, String documentId,Long role , String password, String login
        MyUserDetails myUserDetails = new MyUserDetails(new User (
                user.get().getId(),
                user.get().getName(),
                user.get().getSurname(),
                user.get().getEmail(),
                user.get().getPhoneNumber(),
                user.get().getCountry(),
                user.get().getCity(),
                user.get().getAddress(),
                user.get().getZipCode(),
                user.get().getDocumentId(),
                passwordEncoder.encode(user.get().getPassword()),
                user.get().getLogin())
        );
        logger.info(myUserDetails.getUsername());
        logger.info(myUserDetails.getPassword());
//        return user.map(MyUserDetails::new).get();
        return myUserDetails;
    }
}
