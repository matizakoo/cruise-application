package com.zak.cruise.service.impl;

import com.zak.cruise.dto.UserDTO;
import com.zak.cruise.entity.User;
import com.zak.cruise.repository.UserRepository;
import com.zak.cruise.service.validation.ChangeWordsService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }

//    @Transactional
//    public Optional<User> findUserByEmail(String email) {
//        return userRepository.findUserByEmail(email);
//    }

//    public boolean isExists(String email){
//        return findUserByEmail(email).isPresent();
//    }

    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    public User register(UserDTO userDTO){
        ChangeWordsService change = new ChangeWordsService();
        //password encrypter
        String newPassword = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(newPassword);
        userDTO.setLogin(change.changeLogin(userDTO.getLogin()));
        userDTO.setName(change.changeName(userDTO.getName()));
        userDTO.setSurname(change.changeSurname(userDTO.getSurname()));
        userDTO.setCountry(change.changeCountry(userDTO.getCountry()));
        userDTO.setCity(change.changeCity(userDTO.getCity()));
        User user = new User();
        modelMapper.map(userDTO, user);
        Logger logger = LoggerFactory.getLogger("Connects with /register");
        logger.info("Success");
        return save(user);
    }
}
