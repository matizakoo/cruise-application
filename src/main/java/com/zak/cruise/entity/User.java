package com.zak.cruise.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUser", nullable = false)
    private Long id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "surname")
    @NotNull
    private String surname;
    @Column(name = "email")
    @NotNull
    private String email;
    @Column(name = "phoneNumber")
    @NotNull
    private String phoneNumber;
    @Column(name = "country")
    @NotNull
    private String country;
    @Column(name = "city")
    @NotNull
    private String city;
    @Column(name = "address")
    @NotNull
    private String address;
    @Column(name = "zipCode")
    @NotNull
    private String zipCode;
    @Column(name = "documentId")
    @NotNull
    private String documentId;
    @Column(name = "role_idrole")
    @Value("1")
    private Long role; //TODO
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "login")
    @NotNull
    private String login;
    //the role is first by default (1 - guest, 2 - moderator, 3 - admin)

    public User() {
    }

    public User(Long id, String name, String surname, String email, String phoneNumber, String country, String city, String address, String zipCode, String documentId,Long role , String password, String login) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.documentId = documentId;
        this.role = role;
        this.password = password;
        this.login = login;
    }
}
