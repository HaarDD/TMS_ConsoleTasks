package lesson14_extended;

import base.ConsoleUtil;
import base.TaskRunnable;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class BracesTaskMethodDeque extends TaskRunnable {

    public BracesTaskMethodDeque() {
        super("Правильность вложенности скобок разных видов в строку с Deque");
    }

    @Override
    public void runTask() {
        Map<Character, Character> braces = new HashMap<>();
        braces.put('(', ')');
        braces.put('<', '>');
        braces.put('{', '}');

        String inputString = "(sd(fdsf(sdfdsfsdf)sdfsdf(<dsfdsf>cz12412fs)sdfsdf)";
        ConsoleUtil.println("Введенная строка: " + inputString);
        ConsoleUtil.println(checkBraces(inputString, braces) ? "Порядок скобок верный" : "Порядок скобок НЕверный");
    }

    public boolean checkBraces(String inputString, Map<Character, Character> bracesMap) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : inputString.toCharArray()) {
            if (bracesMap.containsKey(c)) {
                stack.push(c);
            } else if (bracesMap.containsValue(c)) {
                if (stack.isEmpty() || bracesMap.get(stack.pop()) != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }


}
