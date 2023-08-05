package lecture1;

import base.TaskBase;
import base.PrintUtil;
/*Задача 6*. Написать программу которая будет менять местами значение целочисленных
        переменных. Пример:
        int a = 1; int b = 2;
//код (ваше решение)
        sout(a); //выведет 2
        sout(b); //выведет 1*/
public class L1Task6 extends TaskBase {

    public L1Task6(PrintUtil printUtil){
        super(printUtil,6,"Подмена содержимого переменных типа int");    }
    @Override
    public void runTask() {
        int a = (int) printUtil.getNumber("Число a: ",false),
                b = (int)printUtil.getNumber("Число b ",false);
        printUtil.print("До подмены: a = " + a + " b = "+b);
        int temp = a;
        a = b;
        b = temp;
        printUtil.print("После подмены: a = " + a + " b = "+b);
    }
}
