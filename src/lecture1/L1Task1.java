package lecture1;

import base.TaskBase;
import base.PrintUtil;

/* Задача 2. Написать приложение, которое будет вычислять и выводить значение по формуле:
a=4*(b+c-1)/2; b и c задаем в коде самостоятельно.*/
public class L1Task1 extends TaskBase {
    public L1Task1(PrintUtil printUtil) {
        super(printUtil, 2,"Вычисление по формуле a=4*(b+c-1)/2");
    }

    @Override
    public void runTask() {
        printUtil.printOption(this);
        Double b = printUtil.getNumber("Число b: "), c = printUtil.getNumber("Число c: ");
        double result = (4 * (b + c - 1) / 2);
        printUtil.print("Результат: 4 * ("+b+" + "+c+" - 1) / 2 = " + result);
    }
}
