package lecture1;

import base.PrintUtil;
import base.TaskBase;

public class L1Practice extends TaskBase {
    public L1Practice() {
        super(1,"Практика. Вывод имени, фамилии и фозраста в консоль");
    }

    @Override
    public void runTask() {
        PrintUtil.printOption(this);
        PrintUtil.printName("Максим","Галицкий");
        PrintUtil.printNameWithAge("Максим","Галицкий",23);
    }
}
