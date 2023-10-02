package lesson16;

import base.ConsoleUtil;
import base.Runnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/*Задача 1:
Создать коллекцию класса ArrayList наполнить ее элементами типа Integer. С помощью
Stream'ов:
- Удалить дубликаты
- Оставить только четные элементы
- Вывести сумму оставшихся элементов в стриме*/
public class L16Task1 extends Runnable {

    public L16Task1() {
        super("Удаление дубликатов, нечетных элементов и вывод суммы листа Integer");
    }

    @Override
    public void run() {
        List<Integer> integerList = new ArrayList<>(Arrays.asList(1, 2, 2, 3, 3, 4, 5, 6, 7, 8, 8));

        ConsoleUtil.println("Изначальный список чисел:\n" + Arrays.toString(integerList.toArray()));

        List<Integer> filteredIntegerList = integerList.stream().distinct().filter(value -> value % 2 == 0).toList();

        ConsoleUtil.println("Список без дубликтов, нечетных чисел:\n" + Arrays.toString(filteredIntegerList.toArray()) + "\nСумма: " + filteredIntegerList.stream().mapToInt(Integer::intValue).sum());
    }

}
