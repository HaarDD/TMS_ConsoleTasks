package lesson7;

import base.ConsoleUtil;
import base.Runnable;

import java.lang.reflect.Field;

/*Задача *:
Создать класс Apple и добавить в него поле color с модификатором доступа private и
инициализировать его. В методе main другого класса создать объект Apple, и не
используя сеттеры изменить значение поля color.

Источник: https://javarush.com/groups/posts/513-reflection-api-refleksija-temnaja-storona-java*/
public class L7Task2 extends Runnable {

    public L7Task2() {
        super("Изменение приватного поля");
    }

    @Override
    public void run() {
        Apple apple = new Apple();
        ConsoleUtil.println("Изначальный цвет яблока: " + apple.getColor());
        try {
            Field privateField = apple.getClass().getDeclaredField("color");
            privateField.setAccessible(true);
            privateField.set(apple, "Green");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        ConsoleUtil.println("Измененный цвет яблока: " + apple.getColor());

    }

}
