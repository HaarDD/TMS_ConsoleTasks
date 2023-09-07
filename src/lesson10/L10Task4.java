package lesson10;

import base.ConsoleUtil;
import base.Runnable;


/*4. Дана строка произвольной длины с произвольными словами.
Написать программу для проверки является ли любое выбранное слово в
строке палиндромом. Например, есть строка, вводится число 3, значит необходимо проверить
является ли 3-е слово в этой строке палиндромом.
Предусмотреть предупреждающие сообщения на случаи ошибочных
ситуаций: например, в строке 5 слов, а на вход программе передали число
500 и т. п. ситуации.*/
public class L10Task4 extends Runnable {

    public L10Task4() {
        super("Проверка выбранного слова на палиндром");
    }

    @Override
    public void run() {
        StringBuilder textSB;

        while (true) {
            textSB = cleanStringToLettersAndSpaces(ConsoleUtil.getString("Введите слова, разделенные пробелом: "));
            if (textSB.length() > 0) break;
            else ConsoleUtil.println("Слов не найдено! Попробуйте еще раз!");
        }

        int wordIndex = (int) ConsoleUtil.getNumberInRange("Введите порядковый номер слова: ", 1, textSB.length());

        String word = textSB.toString().split(" ")[wordIndex - 1];

        ConsoleUtil.println("Проверяемое слово: " + word);
        ConsoleUtil.println(checkPalindrome(word) ? "Слово является палиндромом" : "Слово НЕ является палиндромом");
    }

    public StringBuilder cleanStringToLettersAndSpaces(String input) {
        StringBuilder cleanedText = new StringBuilder();
        boolean previousIsSpace = false;
        boolean isNotEmpty = false;
        for (char character : input.toCharArray()) {
            if (Character.isLetter(character)) {
                cleanedText.append(character);
                previousIsSpace = false;
                isNotEmpty = true;
            } else if (character == ' ' && !previousIsSpace) {
                cleanedText.append(character);
                previousIsSpace = true;
            }
        }
        if (!isNotEmpty) cleanedText.setLength(0);
        return cleanedText;
    }

    public boolean checkPalindrome(String word) {
        char[] wordLetters = word.toCharArray();
        for (int i = 0; i < wordLetters.length / 2; i++) {
            if (wordLetters[i] != wordLetters[wordLetters.length - i - 1]) {
                return false;
            }
        }
        return true;
    }

}
