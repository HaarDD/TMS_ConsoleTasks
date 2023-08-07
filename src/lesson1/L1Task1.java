package lesson1;

import base.PrintUtil;
import base.TaskBase;

/* Задача 2. Написать приложение, которое будет вычислять и выводить значение по формуле:
a=4*(b+c-1)/2; b и c задаем в коде самостоятельно.*/
public class L1Task1 extends TaskBase {
    public L1Task1() {
        super(2, "Вычисление по формуле a=4*(b+c-1)/2");
    }

    @Override
    public void runTask() {
        PrintUtil.printOption(this);
        Double b = PrintUtil.getNumber("Число b: "), c = PrintUtil.getNumber("Число c: ");
        double result = (4 * (b + c - 1) / 2);
        PrintUtil.print("Результат: 4 * (" + b + " + " + c + " - 1) / 2 = " + result);
    }
}
