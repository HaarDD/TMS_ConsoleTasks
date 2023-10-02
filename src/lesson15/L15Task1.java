package lesson15;

import base.ConsoleUtil;
import base.Runnable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/*Задача 1:
Пользователь вводит в консоль дату своего рождения. Программа должна вернуть дату,
когда пользователю исполнится 100 лет. Использовать Date/Time API.*/
public class L15Task1 extends Runnable {

    public L15Task1() {
        super("Ввод дня рождения и подсчет даты 100-летия");
    }

    @Override
    public void run() {
        LocalDate userBirthday = null;
        while (userBirthday == null) {
            try {
                userBirthday = LocalDate.parse(ConsoleUtil.getString("Введите день рождения (формат - дд.ММ.гггг): "), DateTimeFormatter.ofPattern("dd.MM.yyyy"));
            } catch (DateTimeParseException e) {
                ConsoleUtil.println("Введенная дата не подходит под формат!");
            }
        }
        ConsoleUtil.println("Пользователю " + userBirthday.plusYears(100) + " исполнится 100 лет!");
    }


}
