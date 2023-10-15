package lesson13;

import base.ConsoleUtil;
import base.TaskRunnable;
import lesson13.task2.AnimalsList;


/*Задача 2:
Создать класс, который будет хранить в себе коллекцию с названиями животных.
Реализовать методы удаления и добавления животных по следующим правилам:
добавляется всегда в начало коллекции, а удаляется всегда из конца. Показать работу
объекта этого класса в main методе другого класса.*/
public class L13Task2 extends TaskRunnable {

    public L13Task2() {
        super("Класс с коллекцией, методами добавления в начало и удаления с конца");
    }

    @Override
    public void runTask() {
        AnimalsList animalsList = new AnimalsList();

        animalsList.addAnimal("Корова");
        animalsList.addAnimal("Медведь");
        animalsList.addAnimal("Тигр");

        ConsoleUtil.println(animalsList);

        animalsList.removeAnimal();

        ConsoleUtil.println(animalsList);

        animalsList.addAnimal("Кот");

        ConsoleUtil.println(animalsList);
    }


}
