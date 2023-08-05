package base;

import java.util.Scanner;

public class PrintUtil {
    private static Scanner scanner;

    public double getNumber(String comment, boolean isNatural) {
        print(comment,true);
        scanner = new Scanner(System.in);
        boolean isDoubleInConsole = scanner.hasNextDouble();
        if (isDoubleInConsole) {
            double value = scanner.nextDouble();
            if(isNatural && value < 1){
                print("Это не натуральное число! Попробуйте еще раз");
                return getNumber(comment,isNatural);
            }else{
                return value;
            }
        }
        print("Ошибка ввода числа! Попробуйте еще раз");
        return getNumber(comment,isNatural);

    }

    public void print(Object text) {
        System.out.println(text);
    }
    public void print(Object text, boolean isNotNewLine) {
        if(isNotNewLine)System.out.print(text);
    }

    public void printOption(MenuOption option) {
        print(option.getNumber() + ". " + option.getName());
    }
    public void printLineDelimiter() {
        print("--------------------------");
    }

    public void printName(String name, String surname) {
        print("Имя: " + name + "\nФамилия: " + surname);
    }

    public void printNameWithAge(String name, String surname, int age) {
        print("Имя: " + name + "\nФамилия: " + surname + "\nВозраст: " + age);
    }

}
