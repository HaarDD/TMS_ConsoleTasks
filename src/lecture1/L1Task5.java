package lecture1;

import base.TaskBase;
import base.PrintUtil;

/*Задача 5. В переменных q и w хранятся два натуральных числа. Создайте программу, выводящую
        на экран результат деления q на w с остатком. Пример вывода программы (для случая,
        когда в q хранится 21, а в w хранится 8): 21 / 8 = 2 и 5 в остатке.*/
public class L1Task5 extends TaskBase {

    public L1Task5(PrintUtil printUtil) {
        super(printUtil, 5, "Результат деления с остатком");
    }

    @Override
    public void runTask() {
        int q = (int) printUtil.getNumber("Введите натуральное число q: ", true),
                w = (int) printUtil.getNumber("Введите натуральное число w: ", true);
        printUtil.print("Деление с остатком: " + q + " / " + w + " = " + (q / w) + " и " + (q % w) + " в остатке");
    }
}
