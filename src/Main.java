import base.Lecture;
import base.TaskBase;
import base.TasksSwitcher;
import lecture1.*;
import lecture2.*;

public class Main {
    //Выполнил Максим Галицкий
    public static void main(String[] args) {
        TasksSwitcher tasksSwitcher = new TasksSwitcher();
        tasksSwitcher.addLecture(new Lecture(1,"Введение в Java",
                new TaskBase[]{new L1Practice(),new L1Task1(),new L1Task2and3(),new L1Task4(),new L1Task5(),new L1Task6star()}));
        tasksSwitcher.addLecture(new Lecture(2,"Операторы управления",
                new TaskBase[]{new L2Practice(), new L2Task1(), new L2Task2(), new L2Task3(), new L2Task4(), new L2Task5star()}));
        tasksSwitcher.runTasksSwitcher();
    }

}
