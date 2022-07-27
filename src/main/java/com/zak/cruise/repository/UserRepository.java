package com.zak.cruise.repository;

import com.zak.cruise.entity.User;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<Object> findUserByEmail(String email);
}
