package lesson4;

import base.ConsoleUtil;
import base.Pair;
import base.Runnable;

import java.util.Arrays;

/*Практика:
Задача 1:
Сгенерировать 5 случайных чисел. Каждое возвести в квадрат и вывести в консоль.*/
public class L4Practice1 extends Runnable {

    public L4Practice1() {
        super("Квадраты 5 случайных чисел");
    }

    @Override
    public void run() {
        double[] values = ConsoleUtil.generateRandomDoubleArray(5, new Pair(1, 10), 0);
        ConsoleUtil.println("Исходный массив:\t" + Arrays.toString(values));
        for (int i = 0; i < values.length; i++) {
            values[i] *= values[i];
        }
        ConsoleUtil.println("Квадраты чисел:\t" + Arrays.toString(values));
    }

}
