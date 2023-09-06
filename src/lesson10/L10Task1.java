package lesson10;

import base.ConsoleUtil;
import base.Runnable;


/*Основное задание
1. Написать программу со следующим функционалом:
На вход передать строку (будем считать, что это номер документа).
Номер документа имеет формат xxxx-yyy-xxxx-yyy-xyxy, где x — это число,
а y — это буква.
- Вывести на экран в одну строку два первых блока по 4 цифры.
- Вывести на экран номер документа, но блоки из трех букв заменить
на *** (каждая буква заменятся на *).
- Вывести на экран только одни буквы из номера документа в формате
yyy/yyy/y/y в нижнем регистре.
- Вывести на экран буквы из номера документа в формате
"Letters:yyy/yyy/y/y" в верхнем регистре(реализовать с помощью
класса StringBuilder).
- Проверить содержит ли номер документа последовательность abc и
вывети сообщение содержит или нет(причем, abc и ABC считается
одинаковой последовательностью).
- Проверить начинается ли номер документа с последовательности
555.
- Проверить заканчивается ли номер документа на
последовательность 1a2b.
Все эти методы реализовать в отдельном классе в статических методах,
которые на вход (входным параметром) будут принимать вводимую на вход
программы строку.
Дополнительное задание*/
public class L10Task1 extends Runnable {

    public L10Task1() {
        super("Проверка номера документа формата xxxx-yyy-xxxx-yyy-xyxy и др.");
    }

    @Override
    public void run() {
        String documentNumber = ConsoleUtil.getString("""
                Введите номер документа формата:\s
                "xxxx-yyy-xxxx-yyy-xyxy", где x - число, y - буква
                """, DocNumMethods::validateDocNum);
        ConsoleUtil.println("Номер документа в формате первых двух блоков по 4 цифры: " + DocNumMethods.getPartsString(documentNumber, 1, 3));
        ConsoleUtil.println("Номер документа в формате \"yyy/yyy/y/y\": " + DocNumMethods.getOnlyLetterPartsString(documentNumber, false, null));
        ConsoleUtil.println("Номер документа в формате \"Letters:yyy/yyy/y/y\": " + DocNumMethods.getOnlyLetterPartsString(documentNumber, true, "Letters:"));
        ConsoleUtil.println("Номер документа со скрытыми последовательностями букв: " + DocNumMethods.getWithMaskedPartsString(documentNumber, 2, 4));
        ConsoleUtil.println("Номер документа содержит abc или ABC: " + (documentNumber.contains("abc") | documentNumber.contains("ABC")));
        ConsoleUtil.println("Номер документа начинается с 555: " + documentNumber.startsWith("555"));
        ConsoleUtil.println("Номер документа заканчивается на 1a2b: " + documentNumber.endsWith("1a2b"));

    }


}
