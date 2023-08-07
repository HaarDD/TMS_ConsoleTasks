package lesson2;

import base.PrintUtil;
import base.TaskBase;

/*Задача *:
Напишите программу, где пользователь вводит любое целое положительное число. А
программа суммирует все числа от 1 до введенного пользователем числа. Для ввода
числа воспользуйтесь классом Scanner. Сделать проверку, чтобы пользователь не мог
ввести некорректные данные.*/
public class L2Task5star extends TaskBase {
    public L2Task5star() {
        super(6, "*Сумма от 1 до введенного положительного числа");
    }

    @Override
    public void runTask() {
        PrintUtil.printOption(this);
        int value = (int) PrintUtil.getNaturalNumber("Введите целое положительное число: ");
        int result = 0;
        StringBuilder steps = new StringBuilder();
        for (int i = 2; i < value; i++) {
            result += i;
            steps.append(i).append("+");
        }
        String stepsStr = steps.toString().length() < 1 ? "" : steps.substring(0, steps.length() - 1);
        PrintUtil.print("Сумма чисел от 1 до " + value + " невключительно:\n" + stepsStr + " = " + result);
    }
}
