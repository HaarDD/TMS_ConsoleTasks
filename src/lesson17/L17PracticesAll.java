package lesson17;

import base.ConsoleUtil;
import base.Pair;
import base.Runnable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*1. Написать метод который сможет вернуть все цифры из строки:
“Today my 17th lesson. I’m the best 1! Find me in inst: @teachmeskills”.
2. Написать метод который сможет заменить КАЖДУЮ букву на знак & в строке из 1
задания.
3. Написать метод который сможет вернуть инсту в строке из 1 задания.
4. Написать метод который возвращает true если строка имеет вид “null”.
5. В строке “Hello \n world \n !!!” заменить \n на “” используя классы Pattern и Matcher.
6. В строке “Всем привет!! Меня зовут Билл Гейтс и я мечтаю учиться в TeachMeSkills!”
найти имя и фамилию человека и вывести на экран!*/
public class L17PracticesAll extends Runnable {

    public static final Pattern regexAllNumbers = Pattern.compile("(\\d+|\\d+.\\d+)");
    public static final Pattern regexAllLetters = Pattern.compile("(\\p{L})");
    public static final Pattern regexInstagram = Pattern.compile("inst.+(?<inst>@\\S+)");
    public static final Pattern regexIsNullString = Pattern.compile("^null$");
    public static final Pattern regexAllBackslashN = Pattern.compile("\\\\n");
    public static final Pattern regexFirstLastNames = Pattern.compile("Меня\\s+зовут\\s+(?<firstname>\\p{L}+)\\s+(?<lastname>\\p{L}+)");

    public L17PracticesAll() {
        super("Регулярные выражения (набор)");
    }

    @Override
    public void run() {
        String regexTestCase1 = "Today my 17th lesson. I’m the best 1! Find me in inst: @teachmeskills";
        ConsoleUtil.println("Исходная строка: " + regexTestCase1);
        ConsoleUtil.println("Найденные числа: " + Arrays.toString(matchAllNumbers(regexTestCase1).toArray()));
        ConsoleUtil.println("Строка с замененными буквами на &: " + replaceAllLetters(regexTestCase1));
        ConsoleUtil.println("Инстаграмм: " + findInstagram(regexTestCase1));

        String regexTestCase2 = "null";
        String regexTestCase3 = " null ";

        ConsoleUtil.println("\nРавна ли строка \"null\":\nИсходная строка 1: \"" + regexTestCase2 + "\"\t- "
                + ifStringEqualsNull(regexTestCase2) + "\nИсходная строка 2: \"" + regexTestCase3 + "\"\t- " + ifStringEqualsNull(regexTestCase3));

        String regexTestCase4 = "Hello \\n world \\n !!!";

        ConsoleUtil.println("Исходная строка: " + regexTestCase4 + "\nЗамененные \"\\n\": " + replaceBackslashN(regexTestCase4));

        String regexTestCase5 = "Всем привет!! Меня зовут Билл Гейтс и я мечтаю учиться в TeachMeSkills!";

        ConsoleUtil.println("Исходная строка: " + regexTestCase5 + "\n" + lastFirstNamesFromString(regexTestCase5));

    }

    private List<Double> matchAllNumbers(String inputString) {
        Matcher matcher = regexAllNumbers.matcher(inputString);
        List<Double> numbers = new ArrayList<>();
        while (matcher.find()) numbers.add(Double.parseDouble(matcher.group()));
        return numbers;
    }

    private String replaceAllLetters(String inputString) {
        String replacement = "&";
        Matcher matcher = regexAllLetters.matcher(inputString);
        return matcher.replaceAll(replacement);
    }

    private String findInstagram(String inputString) {
        Matcher matcher = regexInstagram.matcher(inputString);
        if (!matcher.find()) return null;
        try {
            return matcher.group("inst");
        } catch (IllegalStateException | IllegalArgumentException e) {
            return null;
        }
    }

    private boolean ifStringEqualsNull(String inputString) {
        Matcher matcher = regexIsNullString.matcher(inputString);
        return matcher.find();
    }

    private String replaceBackslashN(String inputString) {
        String replacement = "";
        Matcher matcher = regexAllBackslashN.matcher(inputString);
        return matcher.replaceAll(replacement);
    }

    private Pair<String, String> lastFirstNamesFromString(String inputString) {
        Matcher matcher = regexFirstLastNames.matcher(inputString);
        if (!matcher.find()) return null;
        try {
            return new Pair<>(matcher.group("firstname"), matcher.group("lastname"));
        } catch (IllegalStateException | IllegalArgumentException e) {
            return null;
        }
    }
}
