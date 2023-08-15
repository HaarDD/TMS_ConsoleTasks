package lesson1;

import base.ConsoleUtil;
import base.Runnable;

/*Задача 6*. Написать программу которая будет менять местами значение целочисленных
        переменных. Пример:
        int a = 1; int b = 2;
//код (ваше решение)
        sout(a); //выведет 2
        sout(b); //выведет 1*/
public class L1Task6star extends Runnable {

    public L1Task6star() {
        super("Подмена содержимого переменных типа int");
    }

    @Override
    public void run() {
        int a = (int) ConsoleUtil.getNumber("Число a: "),
                b = (int) ConsoleUtil.getNumber("Число b ");
        ConsoleUtil.print("До подмены: a = " + a + " b = " + b);
        int temp = a;
        a = b;
        b = temp;
        ConsoleUtil.print("После подмены: a = " + a + " b = " + b);
    }
}
