package lesson1;

import base.PrintUtil;
import base.TaskBase;

/*Задача 4. В переменной n хранится вещественное число с ненулевой дробной частью. Создайте
        программу, округляющую число n до ближайшего целого и выводящую результат на
        экран.*/
public class L1Task4 extends TaskBase {

    public L1Task4() {
        super(4, "Округление числа до ближайшего целого");
    }

    @Override
    public void runTask() {
        PrintUtil.printOption(this);
        double fractionalNumber = PrintUtil.getNumber("Исходное число: ");
        PrintUtil.print("Округленное число: " + Math.round(fractionalNumber));
    }
}
