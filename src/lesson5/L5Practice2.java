package lesson5;

import base.ConsoleUtil;
import base.DataUtil;
import base.Pair;
import base.Runnable;

import java.util.Arrays;

import static base.ConsoleUtil.DEFAULT_VALUE;
import static base.ConsoleUtil.INPUT_ARR_RANDOM;

/*Задача 2:
Создать зубчатый n-мерный массив(от 3 уровней). Посчитать количество ячеек в нём.*/
public class L5Practice2 extends Runnable {

    public L5Practice2() {
        super("Зубчатый n-мерный массив (от 3 уровней). Подсчет кол-ва ячеек");
    }

    @Override
    public void run() {
        Object[] values = ConsoleUtil.getMultiArrayWithParameters(DEFAULT_VALUE, INPUT_ARR_RANDOM, new Pair(1d, 10d),
                (int) ConsoleUtil.getNumberInRange("Введите уровень вложенности: ", 3, 10));
        ConsoleUtil.println(Arrays.deepToString(values));
        ConsoleUtil.println("Кол-во ячеек: " + DataUtil.lengthOfMultiArray(values));
    }

}
