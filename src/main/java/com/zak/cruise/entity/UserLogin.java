//package com.zak.cruise.entity;
//
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "user")
//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode
//public class UserLogin {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "idUser", nullable = false)
//    private Long id;
//
//    @Column(name = "login")
//    private String login;
//    @Column(name = "password")
//    private String password;
//
//    public UserLogin() {
//    }
//
//    public UserLogin(String login, String password) {
//        this.login = login;
//        this.password = password;
//    }
//}
