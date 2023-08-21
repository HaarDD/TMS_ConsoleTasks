import base.Runnable;
import base.RunnableContainer;
import base.TasksSwitcher;
import lesson1.*;
import lesson2.*;
import lesson3.L3Task1;
import lesson4.*;
import lesson5.*;

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
        tasksSwitcher.runTasksSwitcher();
    }

}
