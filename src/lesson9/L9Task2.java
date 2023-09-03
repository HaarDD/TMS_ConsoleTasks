package lesson9;

import base.ConsoleUtil;
import base.Runnable;
import lesson9.task2.Dog;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;


/*Задача *:
Написать такой конструктор, который запретит создание объекта класса Dog в других
классах; Найти способ вызывать методы voice(), eat() класса Dog, который позволит
обойти ограничение, наложенное конструктором выше. Объяснить, как работают оба
способа*/
public class L9Task2 extends Runnable {

    public L9Task2() {
        super("Вызов методов объекта при условии приватного конструктора класса");
    }

    @Override
    public void run() {
        //метод 1
        ConsoleUtil.println("Метод 1 - доступ к статическому конструктору реализован через singleton");
        Dog dog1 = Dog.getDogInstance();
        dog1.eat("Мясо");
        dog1.voice();
        ConsoleUtil.println("HashCode объекта класса Dog №1: " + dog1.hashCode());

        //метод 2
        ConsoleUtil.println("Метод 2 - доступ к статическому конструктору реализован через reflection API");
        try {
            Constructor<Dog> dogConstructor = Dog.class.getDeclaredConstructor();
            dogConstructor.setAccessible(true);
            Dog dog2 = dogConstructor.newInstance();
            dog2.setName("Мухтар");
            dog2.eat("Мясо");
            dog2.voice();
            ConsoleUtil.println("HashCode объекта класса Dog №2: " + dog2.hashCode());
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

}
