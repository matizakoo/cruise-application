package com.zak.cruise.service.impl;

import com.zak.cruise.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {
    Logger logger = LoggerFactory.getLogger("encoder");
    private String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public MyUserDetails(User user) {
        this.userName = user.getLogin();
        this.password = user.getPassword();
        this.active = user.isActive();
        this.authorities = Arrays.stream("USER".split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
//    private Integer id;
//    private String name;
//    private String surname;
//    private String email;
//    private String phoneNumber;
//    private String country;
//    private String city;
//    private String address;
//    private String zipCode;
//    private String documentId;
//    private Long role; //TODO
//    private String login;
//    private String username;
//    private String password;
//    private boolean active;
//    private List<GrantedAuthority> authorities;
//    @Autowired
//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//
//    public MyUserDetails(User user) {
//        this.id = user.getId();
//        this.name = user.getUsername();
//        this.surname = user.getSurname();
//        this.email = user.getEmail();
//        this.phoneNumber = user.getPhoneNumber();
//        this.country = user.getCountry();
//        this.city = user.getCity();
//        this.address = user.getAddress();
//        this.zipCode = user.getZipCode();
//        this.documentId = user.getDocumentId();
//        this.username = user.getLogin();
//        this.password = passwordEncoder.encode(user.getPassword());
//        this.active = true;
//        this.authorities = Arrays.stream("1".split(","))
//                    .map(SimpleGrantedAuthority::new)
//                    .collect(Collectors.toList());
//    }
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return authorities;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    @Override
//    public String getUsername() {
//        return username;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true ;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return active;
//    }


}
