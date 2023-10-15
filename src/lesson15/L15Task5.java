package lesson15;

import base.ConsoleUtil;
import base.TaskRunnable;

import java.util.function.Supplier;


/*Задача 5:
Используя Supplier написать метод, который будет возвращать введенную с консоли
строку задом наперед.*/
public class L15Task5 extends TaskRunnable {

    public L15Task5() {
        super("Строка задом наперед через Supplier");
    }

    @Override
    public void runTask() {
        Supplier<String> reverseStringConsole = () -> {
            StringBuilder inputStringBuilder = new StringBuilder(ConsoleUtil.getString("Введите строку: "));
            return inputStringBuilder.reverse().toString();
        };

        ConsoleUtil.println("Строка задом наперед: " + reverseStringConsole.get());
    }

}
