package lesson1;

import base.ConsoleUtil;
import base.Runnable;

/*Задача 4. В переменной n хранится вещественное число с ненулевой дробной частью. Создайте
        программу, округляющую число n до ближайшего целого и выводящую результат на
        экран.*/
public class L1Task4 extends Runnable {

    public L1Task4() {
        super("Округление числа до ближайшего целого");
    }

    @Override
    public void run() {
        double fractionalNumber = ConsoleUtil.getNumber("Исходное число: ");
        ConsoleUtil.print("Округленное число: " + Math.round(fractionalNumber));
    }
}
