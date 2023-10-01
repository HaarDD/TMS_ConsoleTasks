package lesson15;

import base.ConsoleUtil;
import base.Runnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*Задача 2:
Используя Predicate среди массива чисел вывести только те, которые являются
положительными.*/
public class L15Task2 extends Runnable {

    public L15Task2() {
        super("Фильтрация массива на положительные числа с помощью Predicate");
    }

    @Override
    public void run() {
        List<Integer> valuesList = new ArrayList<>();
        int listCapacity = (int) ConsoleUtil.getNaturalNumber("Введите размер массива: ");
        for (int i = 0; i < listCapacity; i++) {
            valuesList.add((int) ConsoleUtil.getNumber("Введите " + (i + 1) + "-е число: "));
        }
        List<Integer> positiveValuesList = valuesList.stream().filter(value -> value > 0).toList();
        ConsoleUtil.println("Введенный массив: " + Arrays.toString(valuesList.toArray()) + "\nИз них положительные числа: " + Arrays.toString(positiveValuesList.toArray()));
    }


}
