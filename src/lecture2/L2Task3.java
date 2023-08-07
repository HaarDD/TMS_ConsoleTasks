package lecture2;

import base.PrintUtil;
import base.TaskBase;

/*Задача 3:
Составьте программу, выводящую на экран квадраты чисел от 10 до 20 включительно.*/
public class L2Task3 extends TaskBase {
    public L2Task3() {
        super(4, "Квадраты чисел от 10 до 20 включительно");
    }

    @Override
    public void runTask() {
        PrintUtil.printOption(this);
        StringBuilder result = new StringBuilder("Число[квадрат числа]: ");
        for (int i = 10; i <= 20; i++) {
            result.append(i).append("[").append(i * i).append("] ");
        }
        PrintUtil.print(result.toString());
    }
}
