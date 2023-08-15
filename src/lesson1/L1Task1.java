package lesson1;

import base.ConsoleUtil;
import base.Runnable;

/* Задача 2. Написать приложение, которое будет вычислять и выводить значение по формуле:
a=4*(b+c-1)/2; b и c задаем в коде самостоятельно.*/
public class L1Task1 extends Runnable {
    public L1Task1() {
        super("Вычисление по формуле a=4*(b+c-1)/2");
    }

    @Override
    public void run() {
        Double b = ConsoleUtil.getNumber("Число b: "), c = ConsoleUtil.getNumber("Число c: ");
        double result = (4 * (b + c - 1) / 2);
        ConsoleUtil.print("Результат: 4 * (" + b + " + " + c + " - 1) / 2 = " + result);
    }
}
