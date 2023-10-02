package lesson15;

import base.ConsoleUtil;
import base.Runnable;

import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*Задача 3:
Используя Function реализовать лямбду, которая будет принимать в себя строку в
формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
возвращать сумму, переведенную сразу в доллары.*/
public class L15Task3 extends Runnable {

    public L15Task3() {
        super("(*сумма* BYN) в доллары через Function");
    }

    @Override
    public void run() {
        final double dollarExchangeRate = 3.3d;

        Pattern bynPattern = Pattern.compile("^(\\d+|\\d+.\\d+) BYN");

        Function<String, Double> bynStringValidateToDollars = (inputString) -> {
            Matcher matcher = bynPattern.matcher(inputString);
            if (matcher.find()) return Double.parseDouble(matcher.group(1)) * dollarExchangeRate;
            ConsoleUtil.println("Введенная строка не подходит под формат!");
            return null;
        };

        ConsoleUtil.println("Сумма в долларах: " + bynStringValidateToDollars.apply(ConsoleUtil.getString("Введите сумму в формате (сумма BYN): ")));
    }

}
