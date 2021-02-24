
package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    void testNumberRadioFAIL() throws IllegalArgumentException {
        int actualChannel = -2;
        int actualSoundLevel = 4;
        String actualMessage = null;

        try {
            new Radio(actualChannel, actualSoundLevel);
        } catch (IllegalArgumentException ex1 ) {
            actualMessage = ex1.getMessage();
        }

        String expectedMessage1 = "Ошибка в Radio::Radio(int numberRadio, int soundLevel). Некорректный канал: " + actualChannel;
        assertEquals(expectedMessage1, actualMessage);
    }

    @Test
    void testSoundLevelRadioFAIL() throws IllegalArgumentException {
        int actualChannel = 2;
        int actualSoundLevel = -4;
        String actualMessage = null;

        try {
            new Radio(actualChannel, actualSoundLevel);
        } catch (IllegalArgumentException ex1 ) {
            actualMessage = ex1.getMessage();
        }

        String expectedMessage = "Ошибка в Radio::Radio(int numberRadio, int soundLevel). Некорректный уровень громкости: " + actualSoundLevel;
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testlRadio() {
        int actualChannel = 2;
        int actualSoundLevel = 4;

        Radio radio = new Radio(actualChannel, actualSoundLevel);

        int newActualChannel = radio.getNumberRadio();
        int newActualSoundLevel = radio.getSoundLevel();

        assertEquals(2, newActualChannel);
        assertEquals(4, newActualSoundLevel);
    }

    @Test
    void testSetNumberRadioFAIL() {
        int intitialActualChannel = 6;
        int newActualChannel = -4;
        String actualMessage = null;

        try {
            Radio radio = new Radio(intitialActualChannel);
            radio.setNumberRadio(newActualChannel);
        } catch (IllegalArgumentException ex) {
            actualMessage = ex.getMessage();
        }

        String expectedMessage = "Ошибка в Radio::setNumberRadio. Некорректный канал: " + newActualChannel;
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetNumberRadioOK() {

        int intitialActualChannel = 6;
        int newActualChannel = 8;

        Radio radio = new Radio(intitialActualChannel);
        radio.setNumberRadio(newActualChannel);

        int currentNumberRadio = radio.getNumberRadio();
        assertEquals(newActualChannel, currentNumberRadio);
    }

    @Test
    void testSetLevelSoundRadioFAIL() {
        int intitialActualLevel = 4;
        int newActualLevel = 20;
        String actualMessage = null;

        try {
            Radio radio = new Radio(intitialActualLevel);
            radio.setSoundLevel(newActualLevel);
        } catch (IllegalArgumentException ex){
            actualMessage = ex.getMessage();
        }

        String expectedMessage = "Ошибка в Radio::setSoundLevel. Некорректный уровень громкости: " + newActualLevel;
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetLevelSoundRadioOK() {
        int initialLevelSound = 1;
        int newLevelSound = 5;

        Radio radio = new Radio(initialLevelSound);
        radio.setSoundLevel(newLevelSound);

        int currentLevelSound = radio.getSoundLevel();
        assertEquals(newLevelSound, currentLevelSound);
    }

    @Test
    void testNextOK9() {

        int actualChannal = 9;
        Radio radio1 = new Radio(actualChannal);
        int newActualChannal = radio1.next();

        assertEquals(0, newActualChannal);
    }

    @Test
    void testNextOK4() {

        int actualChannal = 4;
        Radio radio1 = new Radio(actualChannal);
        int newActualChannal = radio1.next();

        assertEquals(5, newActualChannal);
    }

    @Test
    void testPrevOK0() {
        int actualChannal = 0;
        Radio radio1 = new Radio(actualChannal);
        int newActualChannal = radio1.prev();

        assertEquals(9, newActualChannal);
    }

    @Test
    void testPrevOK7() {
        int actualChannal = 7;
        Radio radio1 = new Radio(actualChannal);
        int newActualChannal = radio1.prev();

        assertEquals(6, newActualChannal);
    }

    @Test
    void testPlusOK10(){
        int actualLevelSound = 10;
        Radio radio = new Radio(actualLevelSound);
        int newActualLevelSound = radio.plusSound();

        assertEquals(10, newActualLevelSound);
    }

    @Test
    void testPlusOK6(){
        int actualLevelSound = 6;
        Radio radio = new Radio(actualLevelSound);
        int newActualLevelSound = radio.plusSound();

        assertEquals(7, newActualLevelSound);
    }

    @Test
    void testMinusOK0(){
        int actualLevelSound = 0;
        Radio radio = new Radio(actualLevelSound);
        int newActualLevelSound = radio.minusSound();

        assertEquals(0, newActualLevelSound);
    }

    @Test
    void testMinusOK5(){
        int actualLevelSound = 5;
        Radio radio = new Radio(actualLevelSound);
        int newActualLevelSound = radio.minusSound();

        assertEquals(4, newActualLevelSound);
    }

    @Test
    void getNumberRadio() {
        int actualChannal = 2;
        Radio radio = new Radio(actualChannal);
        int newActualChannal = radio.getNumberRadio();

        assertEquals(2, newActualChannal);
    }

    @Test
    void getSoundLevel() {
        int actualLevelSound = 3;
        Radio radio = new Radio(actualLevelSound);
        int newActualLevelSound = radio.getSoundLevel();

        assertEquals(3, newActualLevelSound);
    }
}