package lesson17;

import base.ConsoleUtil;
import base.TaskRunnable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*Задача *:
Задача 1:
Вывести в консоль из строки которую пользователь вводит с клавиатуры все
аббревиатуры. Аббревиатурой будем считать слово от 2 до 6 символов, состоящее
только из прописных букв, без чисел*/
public class L17Task1 extends TaskRunnable {

    public static final Pattern regexAllNumbers = Pattern.compile("\\p{Lu}{2,6}");

    public L17Task1() {
        super("Поиск аббревиатур");
    }

    @Override
    public void runTask() {
        String regexTestCase = "NASA (National Aeronautics and Space Administration) – Американская организация, занимающаяся исследованием космоса и астрономией." +
                " UNESCO (United Nations Educational, Scientific and Cultural Organization) – Организация Объединенных Наций, посвященная образованию, науке" +
                " и культуре, с целью содействия миру и сотрудничеству между нациями. FIFA (Fédération Internationale de Football Association) – " +
                "Международная футбольная ассоциация, управляющая мировым футболом и организующая Чемпионаты мира по футболу.";

        Matcher matcher = regexAllNumbers.matcher(regexTestCase);
        StringBuilder resultStringBuilder = new StringBuilder();
        while (matcher.find()) {
            resultStringBuilder.append(matcher.group()).append('\n');
        }
        ConsoleUtil.println("Исходный текст: " + regexTestCase + "\nНайденные аббревиатуры: \n" + resultStringBuilder.substring(0, resultStringBuilder.length() - 1));
    }

}
