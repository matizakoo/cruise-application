package com.zak.cruise.repository;

import com.zak.cruise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByLogin(String login);
    User findByEmail(String login);
    @Query(value = "SELECT count(email) FROM user WHERE email = :email", nativeQuery = true)
    int findByEmailz(String email);

    @Query(value = "SELECT count(login) FROM user WHERE login = :login", nativeQuery = true)
    int findByLogiin(String login);

    @Query(value = "SELECT count(login) FROM user WHERE login = :login", nativeQuery = true)
    int ifLoginExists(String login);

    @Query(value = "SELECT idUser FROM user WHERE login = :login", nativeQuery = true)
    Integer getIdOfLogin(String login);

    @Query(value = "SELECT idUser FROM user WHERE password = :password", nativeQuery = true)
    Integer getIdOfpassword(String password);

//    User findByEmail(String email);
}
