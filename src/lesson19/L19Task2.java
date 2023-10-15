package lesson19;

import base.ConsoleUtil;
import base.TaskRunnable;
import lesson19.task2.BubbleSortThread;
import lesson19.task2.InsertionSortThread;
import lesson19.task2.SelectionSortThread;

import java.util.Arrays;

/*Задача 2:
Сортировка массива цифр в нескольких потоках различными алгоритмами:
- сортировка вставками;
- сортировка выбором;
- сортировка пузырьком.
Каждый вид сортировки должен запускаться в отдельном потоке. После вывести
результат отсортированных массивов в консоль.*/
public class L19Task2 extends TaskRunnable {


    public L19Task2() {
        super("Сортировки в разных потоках");
    }

    @Override
    public void runTask() {
        Double[] array = ConsoleUtil.getDoubleArrayMenu(0, 100);
        ConsoleUtil.println(Arrays.toString(array));

        BubbleSortThread bubbleSortThread = new BubbleSortThread(array.clone());
        InsertionSortThread insertionSortThread = new InsertionSortThread(array.clone());
        SelectionSortThread selectionSortThread = new SelectionSortThread(array.clone());


        bubbleSortThread.start();
        insertionSortThread.start();
        selectionSortThread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
