package ru.netology.domain;


public class Radio {
    private static final int CHANNEL_MAX = 9;
    private static final int CHANNEL_MIN = 0;
    private static final int LEVEL_MAX = 10;
    private static final int LEVEL_MIN = 0;

    private int numberRadio;
    private int soundLevel;

    public Radio(int numberRadio, int soundLevel) {
        if ((numberRadio < CHANNEL_MIN || numberRadio > CHANNEL_MAX)) {
            System.out.println("введите номер канала от 0 до 9");
        } else if (soundLevel < LEVEL_MIN  || soundLevel > LEVEL_MAX) {
            System.out.println("введите уровень громкости от 0 до 10 ");
        } else {
            this.numberRadio = numberRadio;
            this.soundLevel = soundLevel;
        }
    }

    public Radio(int initialActualChannel) {
        this.numberRadio = initialActualChannel;
        this.soundLevel = initialActualChannel;
    }

    public Radio() {
    };


    public int getNumberRadio() {
        return numberRadio;
    }

    public int getSoundLevel() {
        return soundLevel;
    }


    public int setNumberRadio (int numberRadio) {
        if (numberRadio < LEVEL_MIN || numberRadio > LEVEL_MAX) {
            System.out.println("введите номер канала от 0 до 9");
        } else {
            this.numberRadio = numberRadio;
        }
        return numberRadio;
    }

    public int setSoundLevel (int soundLevel) { // изменение уровня громкости
        if (soundLevel < LEVEL_MIN || soundLevel > LEVEL_MAX) {
            System.out.println("введите уровень громкости от 0 до 10 ");
        } else {
            this.soundLevel = soundLevel;
        }

        return soundLevel;
    }

    public int next() {
        if (numberRadio == CHANNEL_MAX) {
            numberRadio = 0;
        } else {
            numberRadio = numberRadio + 1;
        }

        return numberRadio;
    }

    public int prev() {
        if (numberRadio == CHANNEL_MIN) {
            numberRadio = 9;
        } else {
            numberRadio = numberRadio - 1;
        }

        return numberRadio;
    }

    public int plusSound (){
        if (soundLevel == LEVEL_MAX) {
            soundLevel = 10;
        } else {
            soundLevel++;
        }

        return soundLevel;
    }

    public int minusSound (){
        if (soundLevel == LEVEL_MIN){
            soundLevel = 0;
        } else {
            soundLevel--;
        }

        return soundLevel;
    }

}