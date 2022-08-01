//package com.zak.cruise.repository;
//
//import com.zak.cruise.dto.UserLoginDTO;
//import com.zak.cruise.entity.UserLogin;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public interface LoginRepository extends JpaRepository<UserLogin, Long> {
//
//    @Query(value = "SELECT idUser FROM user WHERE login = :login", nativeQuery = true)
//    Integer getIdOfLogin(String login);
//
//    @Query(value = "SELECT idUser FROM user WHERE password = :password", nativeQuery = true)
//    Integer getIdOfpassword(String password);
//}

