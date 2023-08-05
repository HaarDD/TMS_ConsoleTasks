package lecture1;

import base.PrintUtil;
import base.TaskBase;

public class L1Practice extends TaskBase {
    public L1Practice(PrintUtil printUtil) {
        super(printUtil, 1,"Практика. Вывод имени, фамилии и фозраста в консоль");
    }

    @Override
    public void runTask() {
        printUtil.printOption(this);
        printUtil.printName("Максим","Галицкий");
        printUtil.printNameWithAge("Максим","Галицкий",23);
    }
}
