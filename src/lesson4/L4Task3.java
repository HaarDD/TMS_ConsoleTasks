package lesson4;

import base.ConsoleUtil;
import base.Runnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Задача 4:
Найти и вывести количество нулевых элементов. Если нулевых элементов нет - вывести
сообщение, что их нет.*/
public class L4Task3 extends Runnable {

    public L4Task3() {
        super("Нахождение нулевых элементов");
    }

    @Override
    public void run() {
        double[] array = ConsoleUtil.getDoubleArrayMenu();
        List<Integer> zeroValues = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                zeroValues.add(i);
            }
        }

        ConsoleUtil.println("Массив:\t\t" + Arrays.toString(array));

        if (!zeroValues.isEmpty()) {
            StringBuilder zeroValuesText = new StringBuilder("Нулевые значения ([индекс:число]): ");
            for (Integer zeroValue : zeroValues) {
                zeroValuesText.append("[").append(zeroValue).append(":").append(array[zeroValue]).append("] ");
            }
            ConsoleUtil.println(zeroValuesText);
        } else {
            ConsoleUtil.println("Нулевых значений нет!");
        }
    }
}
