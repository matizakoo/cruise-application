package com.zak.cruise.service.validation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangeWordsServiceTest {
    ChangeWordsService change = new ChangeWordsService();
    @Test
    void changeLogin() {assertEquals("tiguana", change.changeLogin("TiguaNA"));}
    @Test
    void changeLogin2() {assertEquals("ramster127", change.changeLogin("RamsTer127"));}
    @Test
    void changeLogin3() {assertEquals("pudlo12", change.changeLogin("PUDLO12"));}

    @Test
    void changeName() {assertEquals("Irmina", change.changeName("irmiNa"));}
    @Test
    void changeName2() {assertEquals("Mateusz", change.changeName("mateusz"));}
    @Test
    void changeName3() {assertEquals("Jola", change.changeName("JOla"));}

    @Test
    void changeSurname() {assertEquals("Kowalski", change.changeSurname("kowalski"));}
    @Test
    void changeSurname2() {assertEquals("Zak", change.changeSurname("zAK"));}
    @Test
    void changeSurname3() {assertEquals("Biedrona", change.changeSurname("bIeDrOnA"));}

    @Test
    void changeCountry() {assertEquals("Polska",change.changeCountry("polska"));}
    @Test
    void changeCountry2() {assertEquals("Turcja",change.changeCountry("tUrCja"));}
    @Test
    void changeCountry3() {assertEquals("Wlochy",change.changeCountry("wLochy"));}

    @Test
    void changeCity() {assertEquals("Krakow", change.changeCity("kraKow"));}
    @Test
    void changeCity2() {assertEquals("Czestochowa", change.changeCity("czEstocHowa"));}
    @Test
    void changeCity3() {assertEquals("Malbork", change.changeCity("MaLBORK"));}
}