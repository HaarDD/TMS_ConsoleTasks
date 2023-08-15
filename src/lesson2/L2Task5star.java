package lesson2;

import base.ConsoleUtil;
import base.Runnable;

/*Задача *:
Напишите программу, где пользователь вводит любое целое положительное число. А
программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
числа воспользуйтесь классом Scanner. Сделать проверку, чтобы пользователь не мог
ввести некорректные данные.*/
public class L2Task5star extends Runnable {
    public L2Task5star() {
        super("*Сумма от 1 до введенного положительного числа");
    }

    @Override
    public void run() {
        int value = (int) ConsoleUtil.getNaturalNumber("Введите целое положительное число: ");
        int result = 0;
        StringBuilder steps = new StringBuilder();
        for (int i = 2; i < value; i++) {
            result += i;
            steps.append(i).append("+");
        }
        String stepsStr = steps.toString().length() < 1 ? "" : steps.substring(0, steps.length() - 1);
        ConsoleUtil.print("Сумма чисел от 1 до " + value + " невключительно:\n" + stepsStr + " = " + result);
    }
}
