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
    @OneToOne
    @JoinColumn(name = "role_idrole")
    @Value("1")
    private com.zak.cruise.entity.Role role;
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "login")
    @NotNull
    private String login;
    //the role is first by default (1 - guest, 2 - moderator, 3 - admin)
    private boolean active = true;

//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "role",
//            joinColumns = {@JoinColumn(name="idrole")},
//            inverseJoinColumns = {@JoinColumn(name="role")}
//    )
//    private List<Role> roles = new ArrayList<>();

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
        this.role = role;
        this.password = password;
        this.login = login;
        this.active = true;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return active;
    }

//    public Arrays getRoles() {
//        RoleRepository roleRepository = null;
//        Role role1 = new Role();
//        ArrayList<Role> role =  roleRepository.findAll();
//        return (Arrays) Arrays.asList(role);
//    }
}
