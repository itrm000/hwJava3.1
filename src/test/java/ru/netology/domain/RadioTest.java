
package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    void testNumberChannelRadioFAIL() {
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
    void testSoundLevelRadioFAIL(){
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
    void testChannelAndSoundLevelRadioOk() {
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
            Radio radio = Radio.createRadioWithChannelOnlyAndSoundLevel0(intitialActualChannel);
            radio.setNumberRadio(newActualChannel);
        } catch (IllegalArgumentException ex) {
            actualMessage = ex.getMessage();
        }

        String expectedMessage = "Ошибка в Radio::setNumberRadio. Некорректный канал: " + newActualChannel;
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testSetNumberChanelRadioOK() {

        int intitialActualChannel = 6;
        int newActualChannel = 8;

        Radio radio = Radio.createRadioWithChannelOnlyAndSoundLevel0(intitialActualChannel);
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
            Radio radio = Radio.createRadioWithChannelOnlyAndSoundLevel0(intitialActualLevel);
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

        Radio radio = Radio.createRadioWithSoundOnlyAndChanel0(initialLevelSound);
        radio.setSoundLevel(newLevelSound);

        int currentLevelSound = radio.getSoundLevel();
        assertEquals(newLevelSound, currentLevelSound);
    }

    @Test
    void tesChannelNext9_OK() {

        int actualChannal = 9;
        Radio radio1 =  Radio.createRadioWithChannelOnlyAndSoundLevel0(actualChannal);
        int newActualChannal = radio1.next();

        assertEquals(0, newActualChannal);
    }

    @Test
    void testChannelNext4_OK() {

        int actualChannal = 4;
        Radio radio1 = Radio.createRadioWithChannelOnlyAndSoundLevel0(actualChannal);
        int newActualChannal = radio1.next();

        assertEquals(5, newActualChannal);
    }

    @Test
    void testChannelNext25_FAIL() {

        int actualChannal = 25;
        String actualMessege = null;

        try {
            Radio radio1 = Radio.createRadioWithChannelOnlyAndSoundLevel0(actualChannal);
            radio1.next();
        } catch (IllegalArgumentException ex){
            actualMessege = ex.getMessage();
        }

        String expectedMessege = "Ошибка в Radio::Radio(int initialActualChannel). Некорректный канал: " + actualChannal;
        assertEquals(expectedMessege, actualMessege);
    }

    @Test
    void testChannelPrev0_OK() {
        int actualChannal = 0;
        Radio radio1 = Radio.createRadioWithChannelOnlyAndSoundLevel0(actualChannal);;
        int newActualChannal = radio1.prev();

        assertEquals(9, newActualChannal);
    }

    @Test
    void testChannelPrev7_OK() {
        int actualChannal = 7;
        Radio radio1 =  Radio.createRadioWithChannelOnlyAndSoundLevel0(actualChannal);
        int newActualChannal = radio1.prev();

        assertEquals(6, newActualChannal);
    }

    @Test
    void testChannelPlus10_OK(){
        int actualLevelSound = 10;
        Radio radio = Radio.createRadioWithSoundOnlyAndChanel0(actualLevelSound);
        int newActualLevelSound = radio.plusSound();

        assertEquals(10, newActualLevelSound);
    }

    @Test
    void testChannelPlus6_OK(){
        int actualLevelSound = 6;
        Radio radio = Radio.createRadioWithSoundOnlyAndChanel0(actualLevelSound);
        int newActualLevelSound = radio.plusSound();

        assertEquals(7, newActualLevelSound);
    }

    @Test
    void testChannelPlus27_FAIL(){
        int actualLevelSound = 27;
        String actualMessege = null;

        try {
            Radio radio = Radio.createRadioWithSoundOnlyAndChanel0(actualLevelSound);
            radio.plusSound();
        } catch (IllegalArgumentException ex){
            actualMessege = ex.getMessage();
        }

        String expectedMessege = "Ошибка в Radio::Radio(int soundLevel). Некорректный уровень громкости: " + actualLevelSound;
        assertEquals(expectedMessege, actualMessege);
    }





    @Test
    void testLevelSoundMinus0_OK(){
        int actualLevelSound = 0;
        Radio radio = Radio.createRadioWithSoundOnlyAndChanel0(actualLevelSound);
        int newActualLevelSound = radio.minusSound();

        assertEquals(0, newActualLevelSound);
    }

    @Test
    void testLevelSoundMinus5_OK(){
        int actualLevelSound = 5;
        Radio radio =  Radio.createRadioWithSoundOnlyAndChanel0(actualLevelSound);
        int newActualLevelSound = radio.minusSound();

        assertEquals(4, newActualLevelSound);
    }

    @Test
    void testChanelAndGetterNumberRadioOK() {
        int actualChannal = 2;
        Radio radio = Radio.createRadioWithChannelOnlyAndSoundLevel0(actualChannal);
        int newActualChannal = radio.getNumberRadio();

        assertEquals(2, newActualChannal);
    }

    @Test
    void testSoundLevelAndGetterOK() {
        int actualLevelSound = 3;
        Radio radio = Radio.createRadioWithSoundOnlyAndChanel0(actualLevelSound);
        int newActualLevelSound = radio.getSoundLevel();

        assertEquals(3, newActualLevelSound);
    }
}