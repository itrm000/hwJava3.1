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
            throw new IllegalArgumentException("Ошибка в Radio::Radio(int numberRadio, int soundLevel). Некорректный канал: " + numberRadio);
        } else if (soundLevel < LEVEL_MIN || soundLevel > LEVEL_MAX) {
            throw new IllegalArgumentException("Ошибка в Radio::Radio(int numberRadio, int soundLevel). Некорректный уровень громкости: " + soundLevel);
        } else {
            this.soundLevel = soundLevel;
            this.numberRadio = numberRadio;
        }
    }

    private Radio(int soundLevelAndChanel, boolean soundLevelOrChanel) {

        if (soundLevelOrChanel == true) { // check soundlevel

            int soundLevel = soundLevelAndChanel;

            if ((soundLevel < LEVEL_MIN || soundLevel > LEVEL_MAX)) {
                throw new IllegalArgumentException("Ошибка в Radio::Radio(int soundLevel). Некорректный уровень громкости: " + soundLevel);
            } else {
                this.soundLevel = soundLevel;
            }
        } else if (soundLevelOrChanel == false) { // check chanel
            int actualChannel = soundLevelAndChanel;
            if (actualChannel < CHANNEL_MIN || actualChannel > CHANNEL_MAX) {
                throw new IllegalArgumentException("Ошибка в Radio::Radio(int initialActualChannel). Некорректный канал: " + actualChannel);
            } else {
                this.numberRadio = actualChannel;
            }
        }

    }

    public static Radio createRadioWithSoundOnlyAndChanel0(int soundLevel) {
        return new Radio(soundLevel, true);
    }

    public static Radio createRadioWithChannelOnlyAndSoundLevel0(int channel) {
        return new Radio(channel, false);
    }

    public int getNumberRadio() {
        return numberRadio;
    }

    public int getSoundLevel() {
        return soundLevel;
    }


    public void setNumberRadio(int numberRadio) {
        if (numberRadio < LEVEL_MIN || numberRadio > LEVEL_MAX) {
            throw new IllegalArgumentException("Ошибка в Radio::setNumberRadio. Некорректный канал: " + numberRadio);
        } else {
            this.numberRadio = numberRadio;
        }
    }

    public void setSoundLevel(int soundLevel) {
        if (soundLevel < LEVEL_MIN || soundLevel > LEVEL_MAX) {
            throw new IllegalArgumentException("Ошибка в Radio::setSoundLevel. Некорректный уровень громкости: " + soundLevel);
        } else {
            this.soundLevel = soundLevel;
        }
    }

    public int next() {
        if (numberRadio == CHANNEL_MAX) {
            numberRadio = CHANNEL_MIN;
        } else {
            numberRadio = numberRadio + 1;
        }
        return numberRadio;
    }

    public int prev() {
        if (numberRadio == CHANNEL_MIN) {
            numberRadio = CHANNEL_MAX;
        } else {
            numberRadio = numberRadio - 1;
        }
        return numberRadio;
    }

    public int plusSound() {
        if (soundLevel == LEVEL_MAX) {
            soundLevel = LEVEL_MAX;
        } else {
            soundLevel++;
        }
        return soundLevel;
    }

    public int minusSound() {
        if (soundLevel == LEVEL_MIN) {
            soundLevel = LEVEL_MIN;
        } else {
            soundLevel--;
        }
        return soundLevel;
    }

}