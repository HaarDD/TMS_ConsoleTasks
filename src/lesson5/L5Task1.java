package lesson5;

import base.ConsoleUtil;
import base.DataUtil;
import base.Pair;
import base.Runnable;

import java.util.Arrays;

import static base.ConsoleUtil.INPUT_ARR_RANDOM;

/*Задача 1:
    1.1 Создать двумерный массив, заполнить его случайными числами.
    1.2 Добавить к каждому значению число, которое пользователь будет вводить с консоли.
    1.3 Найти сумму всех получившихся элементов и вывести в консоль.*/
public class L5Task1 extends Runnable {

    public L5Task1() {
        super("Создание двумерного массива и заполнение рандомом. Модификация каждого числа и нахождение их суммы");
    }


    @Override
    public void run() {
        Object[] values = ConsoleUtil.getMultiArrayWithParameters(2, INPUT_ARR_RANDOM, new Pair(1d, 10d), 2);
        ConsoleUtil.println(Arrays.deepToString(values));
        double modification = ConsoleUtil.getNumber("Введите модификатор чисел в массиве: ");
        DataUtil.modificationSpecificNumbersInArray(values, value -> value + modification);
        ConsoleUtil.println(Arrays.deepToString(values));
        ConsoleUtil.println(DataUtil.sumNumbersMultiArray(values));

    }

}
