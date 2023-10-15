package lesson1;

import base.ConsoleUtil;
import base.TaskRunnable;

/*Задача 2. В переменной n хранится двузначное число. Создайте программу, вычисляющую и
    выводящую на экран сумму цифр n. Например: n =26, в результате мы должны получить 8 (2+6).*/
/*Задача 3. В переменной n хранится трёхзначное число. Создайте программу, вычисляющую и
        выводящую на экран сумму цифр n. Например: n =126, в результате мы должны получить
        9 (1+2+6).*/
public class L1Task2and3 extends TaskRunnable {

    public L1Task2and3() {
        super("(2-3) Сумма цифр числа");
    }

    @Override
    public void runTask() {
        int n = (int) ConsoleUtil.getNumber("Исходное число: ");
        int sum = String.valueOf(n).chars().filter(Character::isDigit).map(Character::getNumericValue).sum();
        ConsoleUtil.println("Сумма цифр числа \"" + n + "\": " + sum);
    }
}
