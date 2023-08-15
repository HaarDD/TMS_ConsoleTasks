package lesson4;

import base.ConsoleUtil;
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
        double[] values = new double[5];
        ConsoleUtil.randomizeDoubleArray(values, 1, 10, 0);
        ConsoleUtil.print("Исходный массив:\t" + Arrays.toString(Arrays.stream(values).mapToInt(value -> (int) value).toArray()));
        for (int i = 0; i < values.length; i++) {
            values[i] *= values[i];
        }
        ConsoleUtil.print("Квадраты чисел:\t" + Arrays.toString(Arrays.stream(values).mapToInt(value -> (int) value).toArray()));
    }

}
