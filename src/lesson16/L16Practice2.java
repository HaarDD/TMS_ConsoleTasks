package lesson16;

import base.ConsoleUtil;
import base.TaskRunnable;

import java.util.Arrays;


/*Задача 2:
При помощи стримов из списка строк вывести только те, которые начинаются с буквы ‘A’.*/
public class L16Practice2 extends TaskRunnable {

    public L16Practice2() {
        super("Вывод слов, начинающихся с буквы A");
    }

    @Override
    public void runTask() {
        String[] strings = new String[]{"Яблоко", "Арбуз", "Апельсин", "Персик"};
        ConsoleUtil.println("Первичный список слов: " + Arrays.toString(strings));
        ConsoleUtil.println("Список слов, начинающихся на А: " + Arrays.toString(Arrays.stream(strings).filter(s -> s.startsWith("А")).toArray()));
    }

}
