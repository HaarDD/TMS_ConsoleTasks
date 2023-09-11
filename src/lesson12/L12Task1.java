package lesson12;

import base.ConsoleUtil;
import base.Runnable;

import java.io.*;


/*Задача 1:
В задании приложен файл Ромео и Джульетта на английском, вычитать его в приложении.
Проанализировать и записать в другой файл самое длинное слово.*/
public class L12Task1 extends Runnable {

    public L12Task1() {
        super("Нахождение самого длинного слова в файле romeo_und_julia и запись в файл longest_word");
    }

    @Override
    public void run() {
        String romeoUndJuliaFile = "src/lesson12/task1/romeo_und_julia";
        String longestWordFile = "src/lesson12/task1/longest_word";

        String[] words = getWordsArrayFromFile(romeoUndJuliaFile);

        writeLineToFile(longestWordFile, words[findFirstMaxWordIndex(words)]);

        ConsoleUtil.println(words[findFirstMaxWordIndex(words)]);
    }

    public String[] getWordsArrayFromFile(String filePath) {
        try {
            BufferedReader input_file = new BufferedReader(new FileReader(filePath));
            return input_file.lines()
                    .collect(StringBuilder::new, (stringBuilder, str) -> stringBuilder.append(str).append(' '), StringBuilder::append)
                    .toString().split("[^{a-zA-Z'\\-]+");
        } catch (IOException e) {
            ConsoleUtil.println("Не удалось прочитать файл по пути \"" + filePath + "\"!");
        }
        return new String[]{" "};
    }

    public void writeLineToFile(String filePath, String line) {
        try (BufferedWriter output_file = new BufferedWriter(new FileWriter(filePath))) {
            output_file.write(line);
        } catch (IOException e) {
            ConsoleUtil.println("Не удалось записать строку в файл по пути \"" + filePath + "\"!");
        }
    }

    public int findFirstMaxWordIndex(String[] wordsArray) {
        int maxLength = -Integer.MAX_VALUE;
        int maxWordIndex = -1;
        for (int i = 0; i < wordsArray.length; i++) {
            String word = wordsArray[i];
            if (word.length() > maxLength) {
                maxLength = word.length();
                maxWordIndex = i;
            }
        }
        return maxWordIndex;
    }
}
