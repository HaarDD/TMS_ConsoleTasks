package lesson2;

import base.ConsoleUtil;
import base.TaskRunnable;

        /*Задача 1:
        Ввести с консоли любое число от 1 до 12. В зависимости от введённого числа вывести в
        консоль соответствующую пору года по номеру месяца. При решении использовать
        switch.
        Задача 2:
        Используя while вывести все числа от 0 до 25 в одну строку через пробел.
        Задача 3:
        Используя for вывести каждое четное число от 2 до 20 включительно и больше 10.*/

public class L2Practice extends TaskRunnable {
    public L2Practice() {
        super("Практика. Вывод поры года по номеру, вывод чисел через while (от 0 до 25), вывод чисел через for (четные от 2 до 20 и больше 10)");
    }

    @Override
    public void runTask() {
        double monthNumber = Math.floor(ConsoleUtil.getNumberInRange("Задача №1. Введите номер месяца: ", 1, 12));
        ConsoleUtil.println(getMonthAndSeasonName(monthNumber));

        StringBuilder resultTask2 = new StringBuilder("Задача №2. ");
        int iterator = 0;
        while (iterator <= 25) {
            resultTask2.append(iterator).append(" ");
            iterator++;
        }
        ConsoleUtil.println(resultTask2.toString());

        StringBuilder resultTask3 = new StringBuilder("Задача №3. ");
        for (int i = 2; i <= 20; i += 2) {
            if (i > 10) resultTask3.append(i).append(" ");
        }
        ConsoleUtil.println(resultTask3.toString());
    }

    private String getMonthAndSeasonName(double seasonNumber) {
        String result = "Месяц: ";
        result += switch ((int) seasonNumber) {
            case 1 -> "Январь";
            case 2 -> "Февраль";
            case 3 -> "Март";
            case 4 -> "Апрель";
            case 5 -> "Май";
            case 6 -> "Июнь";
            case 7 -> "Июль";
            case 8 -> "Август";
            case 9 -> "Сентябрь";
            case 10 -> "Октябрь";
            case 11 -> "Ноябрь";
            case 12 -> "Декабрь";
            default -> "Ошибка!";
        };
        result += ", пора года: ";
        result += switch ((int) Math.floor(seasonNumber / 3)) {
            case 0, 4 -> "Зима";
            case 1 -> "Весна";
            case 2 -> "Лето";
            case 3 -> "Осень";
            default -> "Ошибка!";
        };
        return result;
    }

}
