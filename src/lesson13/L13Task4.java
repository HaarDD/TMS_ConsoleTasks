package lesson13;

import base.ConsoleUtil;
import base.TaskRunnable;
import lesson13.task4star.ArrayListCustom;


/*Задача *:
Представим, что в Java нет коллекции типа ArrayList. Создать свой класс, симулирующий
работу класса динамической коллекции - т.е. создать свою кастомную коллекцию. В
основе коллекции будет массив. Кастомная коллекция должна хранить элементы разных
классов(т.е. это generic).
Предусмотреть операции(методы):
1. добавления элемента
2. удаления элемента
3. получение элемента по индексу
4. проверка есть ли элемент в коллекции
5. очистка всей коллекции
Предусмотреть конструктор без параметров - создает массив размером
по умолчанию. Предусмотреть конструктор с задаваемым размером внутреннего
массива. Предусмотреть возможность автоматического расширения коллекции при
добавлении элемента в том случае, когда коллекция уже заполнена.*/
public class L13Task4 extends TaskRunnable {

    public L13Task4() {
        super("Кастомный ArrayList");
    }

    @Override
    public void runTask() {
        ArrayListCustom<String> stringArrayListCustom = new ArrayListCustom<>();

        stringArrayListCustom.add("Первый");
        stringArrayListCustom.add("Второй");
        stringArrayListCustom.add("Третий");

        ConsoleUtil.println("Кастомный ArrayList: " + stringArrayListCustom);

        stringArrayListCustom.remove("Второй");

        ConsoleUtil.println("С удаленным элементом: " + stringArrayListCustom);

        ConsoleUtil.println("Элемент индекса 1: " + stringArrayListCustom.get(1));

        ConsoleUtil.println("Наличие элемента \"Первый\": " + stringArrayListCustom.contains("Первый"));

        stringArrayListCustom.clear();

        ConsoleUtil.println("Размер кастомного ArrayList'а после очистки: " + stringArrayListCustom.size());

    }


}
