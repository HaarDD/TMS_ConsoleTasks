package lesson5;

import base.ConsoleUtil;
import base.DataUtil;
import base.Pair;
import base.Runnable;

import java.util.Arrays;

import static base.ConsoleUtil.INPUT_ARR_RANDOM;

/*Практика:
Задача 1:
1.1 Создайте двумерный массив и заполните его псевдослучайными числами с помощью
класса Random.
1.2 Найдите максимальное значение в созданном 2-мерном массиве.*/
public class L5Practice1 extends Runnable {

    public L5Practice1() {
        super("Создание двумерного массива и заполнение рандомом. Нахождение максимального");
    }

    @Override
    public void run() {
        Object[] values = ConsoleUtil.getMultiArrayWithParameters(3, INPUT_ARR_RANDOM, new Pair(1d, 10d), 2);
        ConsoleUtil.println(Arrays.deepToString(values));
        ConsoleUtil.println("Максимальное число: " + DataUtil.getMaxMinNumberInArray(values, (a, b) -> a < b));
    }

}
