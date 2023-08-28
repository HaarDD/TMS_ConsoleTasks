package lesson4;

import base.ConsoleUtil;
import base.DataUtil;
import base.Runnable;

import java.util.Arrays;

/*Задача 5:
Пройти по массиву и поменять местами элементы первый и последний, второй и
предпоследний и т.д.*/
public class L4Task4 extends Runnable {

    public L4Task4() {
        super("Развернуть массив");
    }

    @Override
    public void run() {
        double[] values = ConsoleUtil.getDoubleArrayMenu();
        ConsoleUtil.println(Arrays.toString(values));
        ConsoleUtil.println(Arrays.toString(DataUtil.revertArray(values)));
    }

}
