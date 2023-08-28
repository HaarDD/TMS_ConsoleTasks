package lesson8;

import base.ConsoleUtil;
import base.Runnable;
import lesson8.task3.Person;

/*Задача *:
Самостоятельно изучить и показать пример работы интерфейса-маркера Cloneable.
Источник: http://echuprina.blogspot.com/2012/02/cloneable.html*/
public class L8Task3 extends Runnable {

    public L8Task3() {
        super("Демонстрация работы интерфейса-маркера Cloneable");
    }

    @Override
    public void run() {

        Person twinOne = new Person("Соболева", "Эльвира", "Константиновна", 10, 10, 1996);
        Person twinTwo = twinOne.clone();
        twinTwo.setName("Марьяна");

        ConsoleUtil.println(twinOne);
        ConsoleUtil.println(twinTwo);
    }

}
