package com.zak.cruise.repository;

import com.zak.cruise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "SELECT count(email) FROM user WHERE email = :email", nativeQuery = true)
    int findByEmailz(String email);

    @Query(value = "SELECT count(login) FROM user WHERE login = :login", nativeQuery = true)
    int findByLogin(String login);

    @Query(value = "SELECT count(login) FROM user WHERE login = :login", nativeQuery = true)
    int ifLoginExists(String login);

    @Query(value = "SELECT idUser FROM user WHERE login = :login", nativeQuery = true)
    Integer getIdOfLogin(String login);

    @Query(value = "SELECT idUser FROM user WHERE password = :password", nativeQuery = true)
    Integer getIdOfpassword(String password);

    User findByEmail(String email);
}
