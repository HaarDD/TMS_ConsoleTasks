package lesson10;

import base.ConsoleUtil;
import base.Runnable;

import java.util.HashSet;


/*3. Дана строка произвольной длины с произвольными словами.
Найти слово, в котором число различных символов минимально. Слово
может содержать буквы и цифры. Если таких слов несколько, найти первое
из них. Например, в строке "fffff ab f 1234 jkjk" найденное слово должно
быть "fffff".*/
public class L10Task3 extends Runnable {

    public L10Task3() {
        super("Нахождение слова, число различных символов которого минимально");
    }

    @Override
    public void run() {
        String text = "fffff ab f 1234 jkjk";
        String[] words = text.split(" ");
        ConsoleUtil.println(findMinUniqueCharsWord(words));
    }

    public String findMinUniqueCharsWord(String[] words) {
        String minUniqueCharWord = null;
        int minUniqueCharsCount = Integer.MAX_VALUE;
        for (String word : words) {
            int uniqueCharsCount = countUniqueChars(word);
            if (uniqueCharsCount < minUniqueCharsCount) {
                minUniqueCharsCount = uniqueCharsCount;
                minUniqueCharWord = word;
            }
        }
        return minUniqueCharWord;
    }

    public int countUniqueChars(String word) {
        HashSet<Character> uniqueChars = new HashSet<>();
        for (char character : word.toCharArray()) {
            uniqueChars.add(character);
        }
        return uniqueChars.size();
    }
}
