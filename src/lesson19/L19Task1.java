package lesson19;

import base.ConsoleUtil;
import base.TaskRunnable;
import lesson19.task1.CompareValuesThread;

import java.util.Arrays;

/*Задача 1:
Пользователь вводит с клавиатуры значение в массив. После чего запускаются два
потока. Первый поток находит максимум в массиве, второй — минимум. Результаты
вычислений возвращаются в метод main().*/
public class L19Task1 extends TaskRunnable {


    public L19Task1() {
        super("Максимальное и минимальное значение массива из консоли");
    }

    @Override
    public void runTask() {
        Double[] array = ConsoleUtil.getDoubleArrayMenu(0, 100);
        ConsoleUtil.println(Arrays.toString(array));

        CompareValuesThread<Double> maxValueThread = new CompareValuesThread<>(array, (a, b) -> a > b);
        CompareValuesThread<Double> minValueThread = new CompareValuesThread<>(array, (a, b) -> a < b);

        maxValueThread.start();
        minValueThread.start();

        Double min = null;
        Double max = null;

        try {
            maxValueThread.join();
            max = maxValueThread.getResult();
            minValueThread.join();
            min = minValueThread.getResult();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ConsoleUtil.println("Максимальное: " + max + " Минимальное " + min);


    }
}
