package lecture2;

import base.PrintUtil;
import base.TaskBase;

/*Задача 2:
Для введенного числа t (температура на улице) вывести: Если t>–5, то вывести «Warm».
Если –5>= t > –20, то вывести «Normal». Если –20>= t, то вывести «Cold».*/
public class L2Task2 extends TaskBase {
    public L2Task2() {
        super(3, "Температура (t>-5: Warm, -5>=t-20: Normal, -20>=t: Cold");
    }

    @Override
    public void runTask() {

        PrintUtil.printOption(this);
        int t = (int) PrintUtil.getNumber("Введите число t: ");
        String result = "Результат: ";
        if ((-5 >= t && t > -20)) {
            result += "Normal";
        } else if (t > -5) {
            result += "Warm";
        } else {
            result += "Cold";
        }
        PrintUtil.print(result);
    }
}
