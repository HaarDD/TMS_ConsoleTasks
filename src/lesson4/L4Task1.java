package lesson4;

import base.ConsoleUtil;
import base.DataUtil;
import base.Runnable;

import java.util.Arrays;

/*Для всех задач исходные условия следующие: пользователь с клавиатуры вводит размер
массива (просто целое число). После того, как размер массива задан, заполнить его
одним из двух способов: используя Math.random(), или каждый элемент массива вводится
пользователем вручную. Попробовать оба варианта. После заполнения массива
данными, решить для него следующие задачи:
Задача 1:
Пройти по массиву, вывести все элементы в прямом и в обратном порядке.*/
public class L4Task1 extends Runnable {

    public L4Task1() {
        super("Проход по массиву, вывод всех элементов в прямом и в обратном порядке.");
    }

    @Override
    public void run() {
        double[] array = ConsoleUtil.getDoubleArrayMenu();
        ConsoleUtil.println("Массив в прямом порядке:\t\t" + Arrays.toString(array));
        ConsoleUtil.println("Массив в обратном порядке:\t" + Arrays.toString(DataUtil.revertArray(array)));
    }
}
