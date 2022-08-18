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
    void checkEmail2(){
        assertFalse(userValidator.checkEmail("@gmail.com"));
    }
    @Test
    void checkEmail3(){
        assertTrue(userValidator.checkEmail(">@3s@@gmail.com"));
    }
    @Test
    void checkEmail4(){
        assertTrue(userValidator.checkEmail("m@m.m"));
    }
    @Test
    void checkEmail5(){
        assertFalse(userValidator.checkEmail("tomojgmail@gmail"));
    }
    @Test
    void checkPhoneNumber(){assertFalse(userValidator.checkPhoneNumber("421421"));}
    @Test
    void checkPhoneNumber2(){assertFalse(userValidator.checkPhoneNumber("sada69"));}
    @Test
    void checkPhoneNumber3(){assertTrue(userValidator.checkPhoneNumber("123123123123"));}
    @Test
    void checkPhoneNumber4(){assertTrue(userValidator.checkPhoneNumber("+48192325231"));}
    @Test
    void checkPhoneNumber5(){assertFalse(userValidator.checkPhoneNumber(null));}
    @Test
    void checkDocumentId(){assertFalse(userValidator.checkDocumentId("394521"));}
    @Test
    void checkDocumentId2(){assertFalse(userValidator.checkDocumentId("12312"));}
    @Test
    void checkDocumentId3(){assertFalse(userValidator.checkDocumentId("hejhyj"));}
    @Test
    void checkDocumentId4(){assertFalse(userValidator.checkDocumentId("1231323532124"));}
    @Test
    void checkDocumentId5(){assertFalse(userValidator.checkDocumentId("+123412421421"));}
    @Test
    void checkZipCode(){assertTrue(userValidator.checkZipCodeFormat("123123"));}
    @Test
    void checkZipCode2(){assertFalse(userValidator.checkZipCodeFormat("12-123"));}
    @Test
    void checkZipCode3(){assertTrue(userValidator.checkZipCodeFormat("CA123"));}
    @Test
    void checkZipCode4(){assertFalse(userValidator.checkZipCodeFormat("Cracov 0-700"));}
    @Test
    void checkZipCode5(){assertTrue(userValidator.checkZipCodeFormat("434523"));}


}