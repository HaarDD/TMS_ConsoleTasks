package lesson8;

import base.Runnable;
import lesson8.task1.positions.Accountant;
import lesson8.task1.positions.Director;
import lesson8.task1.positions.Worker;

/*Задача 1:
Создать классы "Директор", "Рабочий", "Бухгалтер". Реализовать интерфейс с методом,
который печатает название должности и имплементировать этот метод в созданные
классы.*/
public class L8Task1 extends Runnable {

    public L8Task1() {
        super("Интерфейсы \" печать должности\" в классах \"Директор\", \"Рабочий\", \"Бухгалтер\"");
    }

    @Override
    public void run() {

        Director director = new Director("Кузнецов", "Архип", "Тимурович", "Директор отдела продаж");
        Accountant accountant = new Accountant("Егорова", "Лиза", "Руслановна", "Бухгалтер");
        Worker worker = new Worker("Шашков", "Денис", "Витальевич", "Электрик");

        director.printJob();
        accountant.printJob();
        worker.printJob();
    }

}
