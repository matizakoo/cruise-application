package com.zak.cruise.repository;

import com.zak.cruise.dto.UserLoginDTO;
import com.zak.cruise.entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface LoginRepository extends JpaRepository<UserLogin, Long> {
    @Query(value = "SELECT login FROM users WHERE login = :login")
    String getLogin(String login);
}
