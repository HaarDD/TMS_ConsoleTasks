package lecture2;

import base.PrintUtil;
import base.TaskBase;

/*Задача 1:
Напишите программу, которая будет принимать на вход число из консоли и на выход
будет выводить сообщение четное число или нет. Для определения четности числа
используйте операцию получения остатка от деления (операция выглядит так: '% 2').*/
public class L2Task1 extends TaskBase {
    public L2Task1() {
        super( 2,"Определние четности числа через \"% 2\"");
    }

    @Override
    public void runTask() {
        PrintUtil.printOption(this);
        PrintUtil.print((int)PrintUtil.getNumber("Введите число: ")%2==0 ? "Число четное" : "Число нечетное");
    }
}
