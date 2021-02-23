//Задача №1 - "Радиоман"
//        Легенда
//        В рамках проекта по созданию "Умного дома" у нас появился очень важный клиент, которых хочет кастомную доработку: он очень любит радио, поэтому нам нужно научиться управлять радио.
//
//        Что нужно сделать: по аналогии с кондиционером создайте класс Radio, в котором храните следующие поля:
//
//        Номер текущей (прослушиваемой) радиостанции
//        Громкость звука
//        Требования к работе с радиостанциями:
//
//        Номер текущей радиостанции изменяется в пределах от 0 до 9
//        Если текущая радиостанция - 9 и клиент нажал на кнопку next (следующая) на пульте, то текущей должна стать 0-ая
//        Если текущая радиостанция - 0 и клиент нажал на кнопку prev (предыдущая) на пульте, то текущей должна стать 9-ая
//        Клиент должен иметь возможность выставлять номер радиостанции с цифрового пульта (вводя числа 0 - 9)
//        Требования к работе с уровнем громкости звука:
//
//        Клиент должен иметь возможность увеличивать и уменьшать уровень громкости звука (в пределах от 0 до 10)*
//        Если уровень громкости звука достиг максимального значения, то дальнейшее нажатие на + не должно ни к чему приводить
//        Если уровень громкости звука достиг минимального значения, то дальнейшее нажатие на - не должно ни к чему приводить
//        Примечание*: на следующей паре мы поговорим, почему здесь 10
//
//        Важно: один вызов метода должен приводить к переключению на одну радиостанцию!
//
//        Создайте на базе проекта с лекции собственный проект (вы можете использовать проект из предыдущей задачи), в котором:
//
//        Подключите плагин Surefire так, чтобы сборка падала в случае отсутсвия тестов
//        Подключите плагин JaCoCo в режиме генерации отчётов (обрушать сборку по покрытию не нужно)
//        Реализуйте нужные классы и методы
//        Напишите автотесты на методы, содержащие логику, добившись 100% покрытия по branch'ам
//        Подключите CI на базе Github Actions и выложите всё на Github
//        Итого: у вас должен быть репозиторий на GitHub, в котором расположен ваш Java-код.
//
//        Задача №2* - "Цикломатическая сложность кода"
//        Важно: это необязательная задача. Её (не)выполнение не влияет на получение зачёта по ДЗ.
//
//        Важно: эта задача повышенной сложности. Для её выполнения понадобится потратить время на самостоятельный анализ внешних ресурсов.
//
//        Легенда
//        Когда вы разбирались с JaCoCo, одним из счётчиков являлся счётчик, ответственный за подсчёт сложности кода.
//
//        На базе значения этой метрики можно вычислить количество unit-тестов, необходимых для покрытия определённого метода.
//
//        Настройте JaCoCo (если требуется) на подсчёт этой метрики для второй задачи (нас интересуют только методы для обработки next и prev) и удостоверьтесь, что для этих методов кол-во ваших unit-тестов совпадает с рекомендациями метрики.
//
//        В README.md репозитория второй задачи опишите:
//
//        Формулу вычисления количества unit-тестов на основании значений, генерируемых JaCoCo
//        Рекомендуемый порог цикломатической сложности кода (необходимо провести небольшое исследование)
//        В качестве отправной точки при проведении ваших исследований используйте:
//
//        Сайт JaCoCo
//        Википедию (статья о цикломатической сложности кода)

package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {

    @Test
    void testRadioFAIL() throws IllegalArgumentException {
        //when
        int actualChannel = 3;
        int actualSoundLevel = 5;

        Radio radio = new Radio();

        assertEquals(3, actualChannel);
        assertEquals(5, actualSoundLevel);
    }

    @Test
    void testSetNumberRadioFAIL() {
        //when
        int initialActualChannel = 5;

        Radio radio = new Radio(initialActualChannel);
        int newActualChannal = radio.setNumberRadio(initialActualChannel);

        assertEquals(5, newActualChannal);
    }

    @Test
    void testSetLevelSoundRadioFAIL() {
        int intitialActualLevel = 4;

        Radio radio = new Radio(intitialActualLevel);
        int newActualLevel = radio.setSoundLevel(intitialActualLevel);

        assertEquals(4, newActualLevel);
    }

    @Test
    void testNextOK9() {

        int actualChannal = 9;
        Radio radio1 = new Radio(actualChannal);
        int newActualChannal = radio1.next();

        assertEquals(0, newActualChannal);
    }

    @Test
    void testPrevOK0() {
        int actualChannal = 0;
        Radio radio1 = new Radio(actualChannal);
        int newActualChannal = radio1.prev();

        assertEquals(9, newActualChannal);
    }

    @Test
    void testPlusOK10(){
        int actualLevelSound = 10;
        Radio radio = new Radio(actualLevelSound);
        int newActualLevelSound = radio.plusSound();

        assertEquals(10, newActualLevelSound);

    }

    @Test
    void testMinusOK0(){
        int actualLevelSound = 0;
        Radio radio = new Radio(actualLevelSound);
        int newActualLevelSound = radio.minusSound();

        assertEquals(0, newActualLevelSound);
    }

}