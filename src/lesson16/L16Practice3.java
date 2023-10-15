package lesson16;

import base.ConsoleUtil;
import base.TaskRunnable;
import lesson16.practice2.Developer;

import java.util.HashSet;
import java.util.stream.Collectors;


/*Задача 3:
При помощи стримов из списка, содержащего объекты Developer, вывести только те, id >
10 и name начинается с ‘An’.*/
public class L16Practice3 extends TaskRunnable {

    public L16Practice3() {
        super("Разработчики с id больше 10 и началом имени на \"An\":");
    }

    @Override
    public void runTask() {
        HashSet<Developer> developerHashSet = new HashSet<>();

        int developerHashSetCapacity = (int) ConsoleUtil.getNaturalNumber("Количество разработчиков: ");

        for (int i = 0; i < developerHashSetCapacity; i++) {
            if (!developerHashSet.add(new Developer((int) ConsoleUtil.getNaturalNumber("id: "), ConsoleUtil.getString("Имя: ")))) {
                ConsoleUtil.println("Разработчик с таким id уже существует!");
                i--;
            }
        }

        ConsoleUtil.println("Разработчики с id больше 10 и началом имени на \"An\":\n"
                + developerHashSet.stream().filter(developer -> developer.getId() > 10 && developer.getName().startsWith("An"))
                .map(Developer::toString).collect(Collectors.joining("\n")));
    }

}
