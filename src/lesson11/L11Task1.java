package lesson11;

import base.ConsoleUtil;
import base.Runnable;
import lesson11.task1.Authorization;
import lesson11.task1.WrongLoginException;
import lesson11.task1.WrongPasswordException;


/*Задача 1:
Создать класс, в котором будет статический метод. Этот метод принимает на вход три
параметра: login, password, confirmPassword. Все поля имеют тип данных String. Длина
login должна быть меньше 20 символов и не должен содержать пробелы. Если login не
соответствует этим требованиям, необходимо выбросить WrongLoginException. Длина
password должна быть меньше 20 символов, не должен содержать пробелом и должен
содержать хотя бы одну цифру. Также password и confirmPassword должны быть равны.
Если password не соответствует этим требованиям, необходимо выбросить
WrongPasswordException. WrongPasswordException и WrongLoginException -
пользовательские классы исключения с двумя конструкторами – один по умолчанию,
второй принимает сообщение исключения и передает его в конструктор класса Exception.
Метод возвращает true, если значения верны, false в противном случае.*/
public class L11Task1 extends Runnable {

    public L11Task1() {
        super("Проверка логина и пароля, выброс исключения");
    }

    @Override
    public void run() {
        try {
            Authorization.SignUp("User", "password", "password");
        } catch (WrongLoginException | WrongPasswordException e) {
            ConsoleUtil.println(e.toString());
        }
    }

}
