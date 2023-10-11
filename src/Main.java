import base.Runnable;
import base.RunnableContainer;
import base.TasksSwitcher;
import lesson1.*;
import lesson10.*;
import lesson11.L11Task1;
import lesson11.L11Task2;
import lesson12.L12Task1;
import lesson12.L12Task2;
import lesson13.L13Task1;
import lesson13.L13Task2;
import lesson13.L13Task3;
import lesson13.L13Task4;
import lesson14_extended.BracesTaskMethodDeque;
import lesson14_extended.BracesTaskMethodNonDeque;
import lesson14_extended.university.University;
import lesson15.*;
import lesson16.*;
import lesson17.L17PracticesAll;
import lesson17.L17Task1;
import lesson17.L17Task2;
import lesson18.L18Task1;
import lesson18.L18Task2;
import lesson2.*;
import lesson3.L3Task1;
import lesson4.*;
import lesson5.*;
import lesson6.L6Task1;
import lesson6.L6Task2;
import lesson7.L7Task1;
import lesson7.L7Task2;
import lesson8.L8Task1;
import lesson8.L8Task2;
import lesson8.L8Task3;
import lesson9.L9Task1;
import lesson9.L9Task2;

public class Main {
    //Выполнил Максим Галицкий
    public static void main(String[] args) {
        TasksSwitcher tasksSwitcher = new TasksSwitcher();
        tasksSwitcher.addLesson(new RunnableContainer("Введение в Java",
                new Runnable[]{new L1Practice(), new L1Task1(), new L1Task2and3(), new L1Task4(), new L1Task5(), new L1Task6star()}));
        tasksSwitcher.addLesson(new RunnableContainer("Операторы управления",
                new Runnable[]{new L2Practice(), new L2Task1(), new L2Task2(), new L2Task3(), new L2Task4(), new L2Task5star()}));
        tasksSwitcher.addLesson(new RunnableContainer("Система контроля версий Git",
                new Runnable[]{new L3Task1()}));
        tasksSwitcher.addLesson(new RunnableContainer("Одномерные массивы",
                new Runnable[]{new L4Practice1(), new L4Practice2(), new L4Practice3(), new L4Task1(), new L4Task2(), new L4Task3(), new L4Task4(), new L4Task5(), new L4Task6Tree()}));
        tasksSwitcher.addLesson(new RunnableContainer("Двумерные массивы",
                new Runnable[]{new L5Practice1(), new L5Practice2(), new L5Practice3(), new L5Task1(), new L5Task2(), new L5Task3()}));
        tasksSwitcher.addLesson(new RunnableContainer("ООП. Классы и объекты",
                new Runnable[]{new L6Task1(), new L6Task2()}));
        tasksSwitcher.addLesson(new RunnableContainer("ООП в Java. Принципы",
                new Runnable[]{new L7Task1(), new L7Task2()}));
        tasksSwitcher.addLesson(new RunnableContainer("ООП в Java. Интерфейсы и абстрактные классы",
                new Runnable[]{new L8Task1(), new L8Task2(), new L8Task3()}));
        tasksSwitcher.addLesson(new RunnableContainer("ООП в Java. Полиморфизм и статические методы",
                new Runnable[]{new L9Task1(), new L9Task2()}));
        tasksSwitcher.addLesson(new RunnableContainer("Обработка строк",
                new Runnable[]{new L10Task1(), new L10Task2(), new L10Task3(), new L10Task4(), new L10Task5()}));
        tasksSwitcher.addLesson(new RunnableContainer("Исключения и ошибки",
                new Runnable[]{new L11Task1(), new L11Task2()}));
        tasksSwitcher.addLesson(new RunnableContainer("Файлы, потоки ввода/вывода",
                new Runnable[]{new L12Task1(), new L12Task2()}));
        tasksSwitcher.addLesson(new RunnableContainer("Коллекции и Generics",
                new Runnable[]{new L13Task1(), new L13Task2(), new L13Task3(), new L13Task4()}));
        tasksSwitcher.addLesson(new RunnableContainer("Дополнительные задания",
                new Runnable[]{new BracesTaskMethodNonDeque(), new BracesTaskMethodDeque(), new University()}));
        tasksSwitcher.addLesson(new RunnableContainer("Особенности работы с Java 8 (Data/Time API, лямбды)",
                new Runnable[]{new L15Task1(), new L15Task2(), new L15Task3(), new L15Task4(), new L15Task5()}));
        tasksSwitcher.addLesson(new RunnableContainer("Особенности работы с Java 8 (Optional, Stream API)",
                new Runnable[]{new L16Practice1(), new L16Practice2(), new L16Practice3(), new L16Task1(), new L16Task2()}));
        tasksSwitcher.addLesson(new RunnableContainer("Регулярные выражения",
                new Runnable[]{new L17PracticesAll(), new L17Task1(), new L17Task2()}));
        tasksSwitcher.addLesson(new RunnableContainer("Работа с xml (dom,sax)",
                new Runnable[]{new L18Task1(), new L18Task2()}));
        tasksSwitcher.runTasksSwitcher();
    }

}
