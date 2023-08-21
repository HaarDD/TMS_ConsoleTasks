package lesson5;

import base.ConsoleUtil;
import base.Pair;
import base.Runnable;

import static base.ConsoleUtil.INPUT_ARR_RANDOM;
import static base.ConsoleUtil.println;

/*Задача 3:
Найдите сумму элементов на главной диагонали:*/
public class L5Practice3 extends Runnable {

    public L5Practice3() {
        super("Сумма на главной диагонали");
    }

    @Override
    public void run() {
        Object[] values = ConsoleUtil.getMultiArrayWithParameters(3, INPUT_ARR_RANDOM, new Pair(1d, 3d), 2);
        double sum = 0;
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < values[i].length; j++) {
                if (i == j) sum += values[i][j];
            }
        }
        println("Сумма элементов главной диагонали: " + sum);
    }

}
