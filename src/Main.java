import base.Lecture;
import base.PrintUtil;
import base.TaskBase;
import base.TasksSwitcher;
import lecture1.*;


public class Main {
    //Выполнил Максим Галицкий
    public static void main(String[] args) {
        PrintUtil ptUl = new PrintUtil();
        TasksSwitcher tasksSwitcher = new TasksSwitcher();
        tasksSwitcher.addLecture(new Lecture(1,"Введение в Java",
                new TaskBase[]{new L1Task1(ptUl),new L1Task2and3(ptUl),new L1Task4(ptUl),new L1Task5(ptUl),new L1Task6(ptUl)}));

        tasksSwitcher.runTasksSwitcher();

    }

}
