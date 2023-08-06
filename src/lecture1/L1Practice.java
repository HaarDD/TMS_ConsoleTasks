package lecture1;

import base.PrintUtil;
import base.TaskBase;

/*Задача 1:
Создать программу, которая будет выводить в консоли Ваше имя и фамилию.
Задача 2:
Добавить в программу целочисленную переменную с названием age, в которой будет
храниться ваш возраст. Вывести в консоли ваше имя, фамилию и возраст.*/

public class L1Practice extends TaskBase {
    public L1Practice() {
        super(1, "Практика. Вывод имени, фамилии и фозраста в консоль");
    }

    @Override
    public void runTask() {
        PrintUtil.printOption(this);
        PrintUtil.printName("Максим", "Галицкий");
        PrintUtil.printNameWithAge("Максим", "Галицкий", 23);
    }
}
