package lecture1;

import base.TaskBase;

/*Задача 2. В переменной n хранится двузначное число. Создайте программу, вычисляющую и
    выводящую на экран сумму цифр n. Например: n =26, в результате мы должны получить 8 (2+6).*/
/*Задача 3. В переменной n хранится трёхзначное число. Создайте программу, вычисляющую и
        выводящую на экран сумму цифр n. Например: n =126, в результате мы должны получить
        9 (1+2+6).*/
//TODO: сделать очистку введенного числа от лишних знаков (на данный момент учитывает -)
public class L1Task2and3 extends TaskBase {

    public L1Task2and3(){
        super(3,"(2-3) Сумма цифр числа");
    }
    @Override
    public void runTask() {
        printUtil.printOption(this);
        int n = (int)printUtil.getNumber("Исходное число: ");
        int sum = String.valueOf(n).chars().filter(Character::isDigit).map(Character::getNumericValue).sum();
        printUtil.print("Сумма цифр числа \"" + n + "\": " + sum);
    }
}
