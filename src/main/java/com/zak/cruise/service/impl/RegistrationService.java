package com.zak.cruise.service.impl;

import com.zak.cruise.entity.User;
import com.zak.cruise.service.RegisterService;
import com.zak.cruise.service.validation.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService implements RegisterService {
    UserValidator userValidator = null;
    @Override
    public void register(User user) {
        userValidator.validatorInitalizer(user);

    }
}
