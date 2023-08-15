package lesson4;

import base.ConsoleUtil;
import base.DataUtil;
import base.Runnable;

import java.util.Arrays;

/*Практика:
Задача 2:
2.1 Создать массив fruits и заполнить его 4 произвольными фруктами.
2.2 вывести в консоль второй и четвертый.
2.3 вывести в консоль длину массива.
2.4 третий фрукт заменить на иной.
2.5 проверить результат в консоли.*/
public class L4Practice2 extends Runnable {

    public L4Practice2() {
        super("Произвольный массив из 4х фруктов, вывод 2, 4, длины, замена 3го, вывод результата");
    }

    @Override
    public void run() {
        String[] fruits = new String[]{"яблоко", "апельсин", "лимон", "абрикос", "мандарин",
                "груша", "гранат", "персик", "киви", "виноград", "грейпфрут", "манго"};
        String[] fruitsRandomList = DataUtil.randomizeStringArray(fruits, 4);
        ConsoleUtil.print(Arrays.toString(fruitsRandomList));
        ConsoleUtil.print("Второй: " + fruitsRandomList[1] + "\nЧетвертый: " + fruitsRandomList[3] + "\nДлина массива: " + fruitsRandomList.length);
        fruitsRandomList[2] = DataUtil.randomStringArrayValue(fruits);
        ConsoleUtil.print("Изменен 3й элемент:\n" + Arrays.toString(fruitsRandomList));
    }

}
