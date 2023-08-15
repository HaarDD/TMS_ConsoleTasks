package lesson4;

import base.ConsoleUtil;
import base.DataUtil;
import base.Runnable;

import java.util.Arrays;

/*Практика:
Задача 3:
3.1 Создать пустой массив типа double с названием masDouble такого размера, который
пользователь вводит с клавиатуры.
3.2 Заполнить masDouble рандомными числами, используя Math.random() и вывести его в
консоль.
3.3 Каждый чётный элемент masDouble возвести в квадрат. Вывести массив в прямом и
обратном порядке.*/
public class L4Practice3 extends Runnable {

    public L4Practice3() {
        super("Создание массива, заполнением рандомом и вывод квадратов четных чисел в разных порядках");
    }

    @Override
    public void run() {
        double[] masDouble = new double[(int) ConsoleUtil.getNaturalNumber("Введите размер массива: ")];
        ConsoleUtil.randomizeDoubleArray(masDouble, 5, 10, 2);
        ConsoleUtil.print(Arrays.toString(masDouble));
        for (int i = 0; i < masDouble.length; i++) {
            if ((i + 1) % 2 == 0) masDouble[i] = DataUtil.unsafeRoundDouble(masDouble[i] * masDouble[i], 2);
        }
        ConsoleUtil.print(Arrays.toString(masDouble));
        ConsoleUtil.print(Arrays.toString(DataUtil.revertArray(masDouble)));
    }

}