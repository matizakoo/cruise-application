package com.zak.cruise.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "user")
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer id;
    @Column(name = "username")
    @NotNull
    private String username;
    @Column(name = "surname")
    @NotNull
    private String surname;
    @Column(name = "email", unique = true)
    @NotNull
    private String email;
    @Column(name = "phone_number")
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
    @Column(name = "zip_code")
    @NotNull
    private String zipCode;
    @Column(name = "document_id")
    @NotNull
    private String documentId;
//    @Column(name = "role_idrole")
//    @Value("1")
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "login")
    @NotNull
    private String login;
    //the role is first by default (1 - guest, 2 - moderator, 3 - admin)

    @Column(name = "photos_image_path")
    private String photo;

    @Column(name = "active")
    private boolean active = true;

    public User() {
    }

    public User(Integer id, String username, String surname, String email, String phoneNumber, String country, String city, String address, String zipCode, String documentId, String password, String login) {
        this.id = id;
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.documentId = documentId;
        this.password = password;
        this.login = login;
        this.active = true;
        this.photo = null;
    }

    public User(String username, String surname, String email, String phoneNumber, String country, String city, String address, String zipCode, String documentId, String password, String login) {
        this.username = username;
        this.surname = surname;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.country = country;
        this.city = city;
        this.address = address;
        this.zipCode = zipCode;
        this.documentId = documentId;
        this.password = password;
        this.login = login;
        this.active = true;
        this.photo = null;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }
    @Transient
    public String getPhotosImagePath() {
        if (photo == null || id == null)
            return null;

        return "/user-photos/" + id + "/" + photo;
    }
}
