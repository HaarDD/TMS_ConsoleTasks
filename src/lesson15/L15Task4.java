package lesson15;

import base.ConsoleUtil;
import base.Runnable;

import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/*Задача 4:
Используя Consumer реализовать лямбду, которая будет принимать в себя строку в
формате “*сумма* BYN”(через пробел, вместо *сумма* вставить любое значение), а
выводить сумму, переведенную сразу в доллары.*/
public class L15Task4 extends Runnable {

    public L15Task4() {
        super("(*сумма* BYN) в доллары через Consumer");
    }

    @Override
    public void run() {
        final double dollarExchangeRate = 3.3d;

        Pattern bynPattern = Pattern.compile("^(\\d+|\\d+.\\d+) BYN");

        Consumer<String> bynStringValidateToDollars = (inputString) -> {
            Matcher matcher = bynPattern.matcher(inputString);
            if (matcher.find()) {
                ConsoleUtil.println("Сумма в долларах: " + Double.parseDouble(matcher.group(1)) * dollarExchangeRate);
            } else {
                ConsoleUtil.println("Введенная строка не подходит под формат!");
            }
        };

        bynStringValidateToDollars.accept(ConsoleUtil.getString("Введите сумму в формате (сумма BYN): "));
    }

}
