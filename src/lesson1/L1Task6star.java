package lesson1;

import base.PrintUtil;
import base.TaskBase;

/*Задача 6*. Написать программу которая будет менять местами значение целочисленных
        переменных. Пример:
        int a = 1; int b = 2;
//код (ваше решение)
        sout(a); //выведет 2
        sout(b); //выведет 1*/
public class L1Task6star extends TaskBase {

    public L1Task6star() {
        super(6, "Подмена содержимого переменных типа int");
    }

    @Override
    public void runTask() {
        int a = (int) PrintUtil.getNumber("Число a: "),
                b = (int) PrintUtil.getNumber("Число b ");
        PrintUtil.print("До подмены: a = " + a + " b = " + b);
        int temp = a;
        a = b;
        b = temp;
        PrintUtil.print("После подмены: a = " + a + " b = " + b);
    }
}
