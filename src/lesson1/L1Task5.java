package lesson1;

import base.ConsoleUtil;
import base.TaskRunnable;

/*Задача 5. В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую
        на экран результат деления q на w с остатком. Пример вывода программы (для случая,
        когда в q хранится 21, а в w хранится 8): 21 / 8 = 2 и 5 в остатке.*/
public class L1Task5 extends TaskRunnable {

    public L1Task5() {
        super("Результат деления с остатком");
    }

    @Override
    public void runTask() {
        int q = (int) ConsoleUtil.getNaturalNumber("Введите натуральное число q: "),
                w = (int) ConsoleUtil.getNaturalNumber("Введите натуральное число w: ");
        ConsoleUtil.println("Деление с остатком: " + q + " / " + w + " = " + (q / w) + " и " + (q % w) + " в остатке");
    }
}
