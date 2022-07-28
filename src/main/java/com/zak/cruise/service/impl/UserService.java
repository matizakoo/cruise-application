//package com.zak.cruise.service.impl;
//
//import com.zak.cruise.database.DBConnection;
//import com.zak.cruise.dto.UserDTO;
//import com.zak.cruise.entity.User;
//import com.zak.cruise.repository.UserRepository;
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//@Service
//public class UserService {
//    @Autowired
//    private final UserRepository userRepository;
//    private final ModelMapper modelMapper;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository, ModelMapper modelMapper, BCryptPasswordEncoder passwordEncoder){
//        this.userRepository = userRepository;
//        this.modelMapper = modelMapper;
//        this.passwordEncoder = passwordEncoder;
//    }
//    @Transactional
//    public User save(User user){
//        return userRepository.save(user);
//    }
//
//    public User register(UserDTO userDTO){
//        //password encryption
//        String password = passwordEncoder.encode(userDTO.getPassword());
//        userDTO.setPassword(password);
//
//        User user = new User();
//        //map userDTO to user
//        modelMapper.map(userDTO, user);
//        return save(user);
//    }
//
//    public boolean userExists(String email){
//        DBConnection db = new DBConnection();
//        String question = "SELECT name FROM temp";
//        System.out.println(question);
//        return true;
//    }
//}
