package lesson16;

import base.ConsoleUtil;
import base.DataUtil;
import base.Pair;
import base.TaskRunnable;
import lesson16.practice1.User;

import java.util.Optional;


/*Задача 1:
Создать класс User с полем name. В Main создать поле user типа User. Заранее мы не
знаем лежит там объект или отсутствует. Написать логику, которая будет выводить имя
пользователя если объект присутствует в user, либо ‘DEFAULT’ в противном случае.
Использовать класс Optional.*/
public class L16Practice1 extends TaskRunnable {

    public L16Practice1() {
        super("Вывод пользователя или DEFAULT, если не определен");
    }

    @Override
    public void runTask() {
        Optional<User> userOptional = (int) DataUtil.getRandomDoubleRounded(new Pair(0d, 1d), 0) == 0 ? Optional.of(new User("Иван", "Иванов", "Иванович")) : Optional.empty();
        ConsoleUtil.println(userOptional.map(User::toString).orElse("DEFAULT"));
    }

}
