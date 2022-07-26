package com.zak.cruise.service;

import com.zak.cruise.entity.User;

public interface RegisterService {
    void register(User user);
    void login(String login, String password);
    void validatorInitalizer(User user);
}
