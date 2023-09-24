package lesson13;

import base.ConsoleUtil;
import base.Runnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*Задача 1:
Пользователь вводит набор чисел в виде одной строки с клавиатуры. Например: "1, 2, 3,
4, 4, 5". Избавиться от повторяющихся элементов в строке. Вывести результат на экран.
При решении использовать коллекции.*/
public class L13Task1 extends Runnable {

    public L13Task1() {
        super("Удаление дубликатов введенных чисел с консоли с помощью коллекций");
    }

    @Override
    public void run() {
        List<Integer> valuesList = new ArrayList<>();

        while (valuesList.size() == 0) {
            parseStringToValues(ConsoleUtil.getString("Введите набор чисел через запятую с консоли вида \"1,2,14,24\" "), valuesList);
        }

        HashSet<Integer> valuesHashSet = new HashSet<Integer>(valuesList);

        ConsoleUtil.println("Введенный массив чисел: " + Arrays.toString(valuesList.toArray()));
        ConsoleUtil.println("Введенный массив чисел: " + Arrays.toString(valuesHashSet.toArray()));
    }

    public void parseStringToValues(String inputString, List<Integer> valuesListOut) {
        Pattern pattern = Pattern.compile("(\\d+)(?:,|$)");
        Matcher matcher = pattern.matcher(inputString);

        while (matcher.find()) {
            if (matcher.group(1).chars().allMatch(Character::isDigit)) {
                valuesListOut.add(Integer.parseInt(matcher.group(1)));
            }
        }
    }


}
