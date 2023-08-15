package lesson2;

import base.ConsoleUtil;
import base.Runnable;

/*Задача 2:
Для введенного числа t (температура на улице) вывести: Если t>–5, то вывести «Warm».
Если –5>= t > –20, то вывести «Normal». Если –20>= t, то вывести «Cold».*/
public class L2Task2 extends Runnable {
    public L2Task2() {
        super("Температура (t>-5: Warm, -5>=t-20: Normal, -20>=t: Cold");
    }

    @Override
    public void run() {
        int t = (int) ConsoleUtil.getNumber("Введите число t: ");
        String result = "Результат: ";
        if ((-5 >= t && t > -20)) {
            result += "Normal";
        } else if (t > -5) {
            result += "Warm";
        } else {
            result += "Cold";
        }
        ConsoleUtil.print(result);
    }
}
