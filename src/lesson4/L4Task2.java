package lesson4;

import base.ConsoleUtil;
import base.Runnable;

import java.util.Arrays;

/*Задача 2:
Найти минимальный-максимальный элементы и вывести в консоль.
Задача 3:
Найти индексы минимального и максимального элементов и вывести в консоль.*/
public class L4Task2 extends Runnable {

    public L4Task2() {
        super("Нахождение минимального и максимального элемента массива");
    }

    @Override
    public void run() {
        double[] array = ConsoleUtil.getDoubleArrayMenu();
        double min = Double.MAX_VALUE;
        double max = -Double.MAX_VALUE;
        int minIndex = -1, maxIndex = -1;
        for (int i = 0; i < array.length; i++) {
            double value = array[i];
            if (value < min) {
                min = value;
                minIndex = i;
            }
            if (value > max) {
                max = value;
                maxIndex = i;
            }
        }
        ConsoleUtil.println("Массив:\t\t" + Arrays.toString(array));
        ConsoleUtil.println("Минимальное число и его индекс: [" + min + ", " + minIndex + "]");
        ConsoleUtil.println("Максимальное число и его индекс: [" + max + ", " + maxIndex + "]");
    }
}
