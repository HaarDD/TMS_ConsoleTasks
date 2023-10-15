package lesson10;

import base.ConsoleUtil;
import base.TaskRunnable;

import java.util.ArrayList;
import java.util.List;


/*Основное задание
2. Дана строка произвольной длины с произвольными словами.
Найти самое короткое слово в строке и вывести его на экран.
Найти самое длинное слово в строке и вывести его на экран.
Если таких слов несколько, то вывести последнее из них.*/
public class L10Task2 extends TaskRunnable {

    public L10Task2() {
        super("Нахождение минимальных слов и максимальных");
    }

    @Override
    public void runTask() {
        String text = "cat dog horse whale bear tiger";
        String[] words = text.split(" ");


        List<String> minWords = new ArrayList<>(1);
        List<String> maxWords = new ArrayList<>(1);

        findMinMaxWord(words, minWords, maxWords);

        ConsoleUtil.println(minWords);
        ConsoleUtil.println(maxWords);
    }

    public void findMinMaxWord(String[] wordsArray, List<String> minWords, List<String> maxWords) {
        int minLength = Integer.MAX_VALUE;
        int maxLength = -Integer.MAX_VALUE;
        for (String word : wordsArray) {
            if (word.length() < minLength) {
                minWords.clear();
                minWords.add(word);
                minLength = word.length();
            } else if (word.length() == minLength) {
                minWords.add(word);
            }
            if (word.length() > maxLength) {
                maxWords.clear();
                maxWords.add(word);
                maxLength = word.length();
            } else if (word.length() == maxLength) {
                maxWords.add(word);
            }
        }
    }

}
