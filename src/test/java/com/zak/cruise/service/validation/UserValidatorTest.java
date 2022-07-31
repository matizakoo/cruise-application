package com.zak.cruise.service.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserValidatorTest {
    UserValidator userValidator = new UserValidator();
    @Test
    void checkPassword() {
        assertTrue(userValidator.validatePassword("nccseiMDWwd21"));
    }

    @Test
    void checkPassword2() {
        assertTrue(userValidator.validatePassword("cs/;einSNci.amo35"));
    }

    @Test
    void checkPassword3() {
        assertTrue(userValidator.validatePassword("viam3321ascDS"));
    }

    @Test
    void checkPassword4() {
        assertFalse(userValidator.validatePassword("cxsfaf;@dssw3"));
    }

    @Test
    void checkPassword5() {
        assertTrue(userValidator.validatePassword("nccseiM#DkhgyvuuyvhjthvvhjcWwd21"));
    }

    @Test
    void checkSurname() {
        assertTrue(userValidator.checkSurname("assadas"));
    }

    @Test
    void checkSurname2() {
        assertFalse(userValidator.checkSurname(null));
    }

    @Test
    void checkSurname3() {
        assertTrue(userValidator.checkSurname("Karmelek"));
    }

    @Test
    void checkSurname4() {
        assertTrue(userValidator.checkSurname("Duzyskurwiol"));
    }

    @Test
    void checkLogin(){
        assertTrue(userValidator.checkLogin("tosuperlogin"));
    }
    @Test
    void checkLogin2(){
        assertFalse(userValidator.checkLogin("fmas@fd.s"));
    }

    @Test
    void checkLogin3(){
        assertFalse(userValidator.checkLogin(null));
    }

    @Test
    void checkLogin4(){
        assertFalse(userValidator.checkLogin("Bardzo duzy login"));
    }

    @Test
    void checkLogin5(){
        assertTrue(userValidator.checkLogin("Bardzoduzylogin"));
    }

    @Test
    void checkEmail(){
        assertTrue(userValidator.checkEmail("tomojgmail@gmail.com"));
    }

    @Test
    void checkTest(){
        assertTrue(userValidator.checkEmail("tomojgmail@gmail.com"));
    }
    @Test
    void checkTest2(){
        assertFalse(userValidator.checkEmail("tomojgmail@gmailcom"));
    }
    @Test
    void checkTest3(){
        assertFalse(userValidator.checkEmail("tomojgmail@gmail."));
    }
    @Test
    void checkTest4(){
        assertFalse(userValidator.checkEmail("@gmail.com"));
    }
    @Test
    void checkTest5(){
        assertFalse(userValidator.checkEmail("tomojgmail@"));
    }

}