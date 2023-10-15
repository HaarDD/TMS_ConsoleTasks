package lesson4;

import base.ConsoleUtil;
import base.DataUtil;
import base.Pair;
import base.TaskRunnable;

import java.util.Arrays;

/*Практика:
Задача 3:
3.1 Создать пустой массив типа double с названием masDouble такого размера, который
пользователь вводит с клавиатуры.
3.2 Заполнить masDouble рандомными числами, используя Math.random() и вывести его в
консоль.
3.3 Каждый чётный элемент masDouble возвести в квадрат. Вывести массив в прямом и
обратном порядке.*/
public class L4Practice3 extends TaskRunnable {

    public L4Practice3() {
        super("Создание массива, заполнением рандомом и вывод квадратов четных чисел в разных порядках");
    }

    @Override
    public void runTask() {
        Double[] masDouble = ConsoleUtil.generateRandomDoubleArray((int) ConsoleUtil.getNaturalNumber("Введите размер массива: "), new Pair(5, 10), 2);
        ConsoleUtil.println(Arrays.toString(masDouble));
        for (int i = 0; i < masDouble.length; i++) {
            if ((i + 1) % 2 == 0) masDouble[i] = DataUtil.unsafeRoundDouble(masDouble[i] * masDouble[i], 2);
        }
        ConsoleUtil.println(Arrays.toString(masDouble));
        ConsoleUtil.println(Arrays.toString(DataUtil.reverseArray(masDouble)));
    }

}
