package base;

import java.util.Scanner;

public class PrintUtil {
    private static double getNumber(String comment, boolean isNatural, double minValue, double maxValue) {
        print(comment,true);
        Scanner scanner = new Scanner(System.in);
        boolean isDoubleInConsole = scanner.hasNextDouble();
        if (isDoubleInConsole) {
            double value = scanner.nextDouble();
            if(isNatural && value < 1){
                print("Это не натуральное число! Попробуйте еще раз");
                return getNumber(comment,isNatural,minValue,maxValue);
            }else if(value<minValue || value>maxValue){
                print("Число не входит в допустимый диапазон! Попробуйте еще раз");
                return getNumber(comment,isNatural,minValue,maxValue);
            } else {
                return value;
            }
        }
        print("Ошибка ввода числа! Попробуйте еще раз");
        return getNumber(comment,isNatural,minValue,maxValue);

    }

    public static double getNumber(String comment) {
        return getNumber(comment,false,Double.MIN_VALUE,Double.MAX_VALUE);
    }

    public static double getNaturalNumber(String comment) {
        return getNumber(comment,true,Double.MIN_VALUE,Double.MAX_VALUE);
    }

    public static double getNumberInRange(String comment, double minValue, double maxValue) {
        return getNumber(comment,false,minValue,maxValue);
    }

    public static void print(Object text) {
        System.out.println(text);
    }
    public static void print(Object text, boolean isNotNewLine) {
        if(isNotNewLine)System.out.print(text);
    }

    public static void printOption(MenuOption option) {
        print(option.getNumber() + ". " + option.getName());
    }
    public static void printLineDelimiter() {
        print("--------------------------");
    }

    public static void printName(String name, String surname) {
        print("Имя: " + name + "\nФамилия: " + surname);
    }

    public static void printNameWithAge(String name, String surname, int age) {
        print("Имя: " + name + "\nФамилия: " + surname + "\nВозраст: " + age);
    }

}
