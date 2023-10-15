package lesson6;

import base.ConsoleUtil;
import base.TaskRunnable;

/*Задача 1:
Создать класс CreditCard c полями номер счета, текущая сумма на счету. Добавьте
метод, который позволяет начислять сумму на кредитную карточку. Добавьте метод,
который позволяет снимать с карточки некоторую сумму. Добавьте метод, который
выводит текущую информацию о карточке. Напишите программу, которая создает три
объекта класса CreditCard у которых заданы номер счета и начальная сумма.
Тестовый сценарий для проверки: Положите деньги на первые две карточки и снимите с
третьей. Выведите на экран текущее состояние всех трех карточек.*/
public class L6Task1 extends TaskRunnable {

    public L6Task1() {
        super("Класс CreditCard");
    }

    @Override
    public void runTask() {
        CreditCard creditCard1 = new CreditCard("Иванов Иван", 5364566891011213L, 1000);
        CreditCard creditCard2 = new CreditCard("Сергеев Сергей", 1225567691051253L, 2000);
        CreditCard creditCard3 = new CreditCard(1234567891011213L, 3000);

        ConsoleUtil.printLineDelimiter();
        ConsoleUtil.println("До операций с карточками");
        ConsoleUtil.printLineDelimiter();
        creditCard1.printCardInfo();
        creditCard2.printCardInfo();
        creditCard3.printCardInfo();

        creditCard1.putMoney(500);
        creditCard2.putMoney(1000);
        creditCard3.withdrawMoney(2000);

        ConsoleUtil.printLineDelimiter();
        ConsoleUtil.println("После операций с карточками");
        ConsoleUtil.printLineDelimiter();
        creditCard1.printCardInfo();
        creditCard2.printCardInfo();
        creditCard3.printCardInfo();
    }
}
