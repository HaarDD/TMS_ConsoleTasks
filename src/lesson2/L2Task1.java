package lesson2;

import base.ConsoleUtil;
import base.Runnable;

/*Задача 1:
Напишите программу, которая будет принимать на вход число из консоли и на выход
будет выводить сообщение четное число или нет. Для определения четности числа
используйте операцию получения остатка от деления (операция выглядит так: '% 2').*/
public class L2Task1 extends Runnable {
    public L2Task1() {
        super("Определние четности числа через \"% 2\"");
    }

    @Override
    public void run() {
        ConsoleUtil.print((int) ConsoleUtil.getNumber("Введите число: ") % 2 == 0 ? "Число четное" : "Число нечетное");
    }
}
