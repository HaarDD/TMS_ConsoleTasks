package lesson1;

import base.ConsoleUtil;
import base.Runnable;

/*Задача 1:
Создать программу, которая будет выводить в консоли Ваше имя и фамилию.
Задача 2:
Добавить в программу целочисленную переменную с названием age, в которой будет
храниться ваш возраст. Вывести в консоли ваше имя, фамилию и возраст.*/

public class L1Practice extends Runnable {
    public L1Practice() {
        super("Практика. Вывод имени, фамилии и фозраста в консоль");
    }

    @Override
    public void run() {
        ConsoleUtil.println(this.getName());
        ConsoleUtil.printName("Максим", "Галицкий");
        ConsoleUtil.printNameWithAge("Максим", "Галицкий", 23);
    }
}
