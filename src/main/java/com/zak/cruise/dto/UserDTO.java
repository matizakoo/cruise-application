//package com.zak.cruise.dto;
//
//import com.zak.cruise.entity.Roles;
//import org.hibernate.validator.constraints.Length;
//
//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//
//public class UserDTO {
//    @NotBlank(message = "Enter your name")
//    private String name;
//    @NotBlank(message = "Enter your surname")
//    private String surname;
//    @NotBlank(message = "Enter your password")
//    @Length(min = 8, max = 20, message = "Password must be valid and at least 8 and max 20 chars")
//    private String password;
//    @NotBlank(message = "Re-enter password")
//    private String repeatPassword;
//    @NotBlank(message = "Enter your email")
//    @Email(message = "Enter valid email")
//    private String email;
//    @NotBlank(message = "Enter your phone number")
//    @Length(min = 9, message = "At least 9 symbols")
//    private String phoneNumber;
//    @NotBlank(message = "Enter your country")
//    private String country;
//    @NotBlank(message = "Enter your city")
//    private String city;
//    @NotBlank(message = "Enter your address")
//    private String address;
//    @NotBlank(message = "Enter your zipcode")
//    private String zipCode;
//    private Roles role;
//    @NotBlank(message = "Enter your login")
//    private String login;
//
//    public UserDTO() {
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getSurname() {
//        return surname;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getRepeatPassword() {
//        return repeatPassword;
//    }
//
//    public void setRepeatPassword(String repeatPassword) {
//        this.repeatPassword = repeatPassword;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public String getZipCode() {
//        return zipCode;
//    }
//
//    public void setZipCode(String zipCode) {
//        this.zipCode = zipCode;
//    }
//
//    public Roles getRole() {
//        return role;
//    }
//
//    public void setRole(Roles role) {
//        this.role = role;
//    }
//
//    public String getLogin() {
//        return login;
//    }
//
//    public void setLogin(String login) {
//        this.login = login;
//    }
//
//    @Override
//    public String toString() {
//        return "UserDTO{" +
//                "name='" + name + '\'' +
//                ", surname='" + surname + '\'' +
//                ", passowrd='" + password + '\'' +
//                ", repeatPassword='" + repeatPassword + '\'' +
//                ", email='" + email + '\'' +
//                ", phoneNumber='" + phoneNumber + '\'' +
//                ", country='" + country + '\'' +
//                ", city='" + city + '\'' +
//                ", address='" + address + '\'' +
//                ", zipCode='" + zipCode + '\'' +
//                ", role=" + role +
//                ", login='" + login + '\'' +
//                '}';
//    }
//}
