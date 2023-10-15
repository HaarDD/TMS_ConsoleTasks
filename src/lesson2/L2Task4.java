package lesson2;

import base.ConsoleUtil;
import base.TaskRunnable;

/*Задача 4:
Необходимо, чтоб программа выводила на экран вот такую последовательность:
7 14 21 28 35 42 49 56 63 70 77 84 91 98. В решении используйте цикл while.*/
public class L2Task4 extends TaskRunnable {
    public L2Task4() {
        super("Вывод последовательности с шагом 7 (while)");
    }

    @Override
    public void runTask() {
        StringBuilder result = new StringBuilder("Последовательность: ");
        int i = 7;
        while (i <= 98) {
            result.append(i).append(" ");
            i += 7;
        }
        ConsoleUtil.println(result.toString());

    }
}
