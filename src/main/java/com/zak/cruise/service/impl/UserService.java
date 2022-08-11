package com.zak.cruise.service.impl;

import com.zak.cruise.dto.UserDTO;
import com.zak.cruise.entity.Role;
import com.zak.cruise.entity.User;
import com.zak.cruise.repository.UserRepository;
import com.zak.cruise.service.validation.ChangeWordsService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Locale;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
//    private final DelegatingPasswordEncoder passwordEncoder;
    private final BCryptPasswordEncoder passwordEncoder;
    Logger logger = LoggerFactory.getLogger("Connects with /register");

    @Autowired
    public UserService(UserRepository userRepository, ModelMapper modelMapper, /*DelegatingPasswordEncoder*/BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Transactional
    public User save(User user){
        return userRepository.save(user);
    }

    public User register(UserDTO userDTO){
        ChangeWordsService change = new ChangeWordsService();
//        BCryptPasswordEncoder crypt = new BCryptPasswordEncoder();
//        String password = crypt.encode(userDTO.getPassword());
        userDTO.setPassword(userDTO.getPassword());
        userDTO.setLogin(change.changeLogin(userDTO.getLogin()));
        userDTO.setUsername(change.changeName(userDTO.getUsername()));
        userDTO.setSurname(change.changeSurname(userDTO.getSurname()));
        userDTO.setCountry(change.changeCountry(userDTO.getCountry()));
        userDTO.setCity(change.changeCity(userDTO.getCity()));
        User user = new User();
        modelMapper.map(userDTO, user);

        logger.info("Success registration");
        return save(user);
    }

    public Optional<User> getUserDetails(String login){
        return userRepository.findByLogin(login);
    }

    public void uploadPhoto(String photo, User user){
        user.setPhoto(photo);
        userRepository.save(user);
    }

    public void createDirectory(MultipartFile multipartFile,String fileName,User user) throws IOException {
        String uploadDir = "user-photos/" + user.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
    }

    public boolean isPhotoSet(String login){
        if(userRepository.findByLogin(login).isPresent() &&
                userRepository.findByLogin(login).get().getPhoto() != null){
            return true;
        }
        return false;
    }
}
