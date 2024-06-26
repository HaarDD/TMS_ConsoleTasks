package lesson2;

import base.ConsoleUtil;
import base.TaskRunnable;

/*Задача 3:
Составьте программу, выводящую на экран квадраты чисел от 10 до 20 включительно.*/
public class L2Task3 extends TaskRunnable {
    public L2Task3() {
        super("Квадраты чисел от 10 до 20 включительно");
    }

    @Override
    public void runTask() {
        StringBuilder result = new StringBuilder("Число[квадрат числа]: ");
        for (int i = 10; i <= 20; i++) {
            result.append(i).append("[").append(i * i).append("] ");
        }
        ConsoleUtil.println(result.toString());
    }
}
