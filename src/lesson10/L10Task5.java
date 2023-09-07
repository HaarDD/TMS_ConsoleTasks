package lesson10;

import base.ConsoleUtil;
import base.Runnable;

/*5. Дана произвольная строка.
Вывести на консоль новую строку, которой задублирована каждая буква из
начальной строки.
Например, "Hello" -> "HHeelllloo".*/
public class L10Task5 extends Runnable {

    public L10Task5() {
        super("Дублирование букв в строке");
    }

    @Override
    public void run() {
        StringBuilder textSB = new StringBuilder(ConsoleUtil.getString("Введите любой текст: "));
        duplicateLetters(textSB);
        ConsoleUtil.println("Строка с продублированными буквами: " + textSB);
    }

    public void duplicateLetters(StringBuilder text) {
        char[] textChars = text.toString().toCharArray();
        int appendedCount = 0;
        for (int i = 0; i < textChars.length; i++) {
            if (Character.isLetter(textChars[i])) {
                text.insert(i + appendedCount, textChars[i]);
                appendedCount++;
            }
        }
    }


}
