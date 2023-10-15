package lesson14_extended;

import base.ConsoleUtil;
import base.TaskRunnable;

import java.util.HashMap;
import java.util.Map;


/*Задача 1:
В задании приложен файл Ромео и Джульетта на английском, вычитать его в приложении.
Проанализировать и записать в другой файл самое длинное слово.*/
public class BracesTaskMethodNonDeque extends TaskRunnable {

    public BracesTaskMethodNonDeque() {
        super("Правильность вложенности скобок разных видов в строку без Deque");
    }

    @Override
    public void runTask() {
        Map<Character, Character> braces = new HashMap<>();
        braces.put('(', ')');
        braces.put('<', '>');
        braces.put('{', '}');

        String inputString = "(sdfdsf(sdfdsfsdf)sdfsdf(<dsfdsf>cz12412fs)sdfsdf)";
        ConsoleUtil.println("Введенная строка: " + inputString);
        ConsoleUtil.println(checkBraces(onlyBracesCharsFromString(inputString, braces), braces) ? "Порядок скобок верный" : "Порядок скобок НЕверный");

    }

    public boolean checkBraces(char[] inputCharArray, Map<Character, Character> bracesMap) {
        char[] charArray = inputCharArray.clone();
        int openedBraceIndex = -1;
        Character braceNext = null;
        for (int i = 0; i < charArray.length; i++) {
            if (braceNext != null && charArray[i] == braceNext) {
                char[] arrayWithoutBracesPair = removeRange(charArray, openedBraceIndex, i);
                if (arrayWithoutBracesPair.length == 0) {
                    return true;
                } else {
                    return checkBraces(arrayWithoutBracesPair, bracesMap);
                }
            }
            Character checkNextBrace = bracesMap.get((char) charArray[i]);
            if (checkNextBrace != null) {
                openedBraceIndex = i;
                braceNext = checkNextBrace;
            }
        }
        return false;
    }


    public char[] removeRange(char[] originalArray, int from, int to) {
        if (from < 0 || to >= originalArray.length || from > to) {
            return originalArray.clone();
        }
        int newArrayLength = originalArray.length - (to - from + 1);
        char[] newArray = new char[newArrayLength];
        int newIndex = 0;
        for (int i = 0; i < originalArray.length; i++) {
            if (i < from || i > to) {
                newArray[newIndex] = originalArray[i];
                newIndex++;
            }
        }
        return newArray;
    }

    public char[] onlyBracesCharsFromString(String inputString, Map<Character, Character> bracesMap) {
        return inputString.chars().filter(character -> bracesMap.containsKey((char) character) || bracesMap.containsValue((char) character))
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString().toCharArray();
    }


}
