package base;

import java.util.Scanner;

public class ConsoleUtil {
    //константы для определения типов ввода массива
    public static final int INPUT_ARR_RANDOM = 1;
    public static final int INPUT_ARR_MANUAL = 2;
    public static final int INPUT_ARR_RANDOM_MANUAL = 3;


    //Функции получаения чисел из консоли с различными параметрами
    public static double getNumber(String comment) {
        return getNumber(comment, false, -Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public static double getNaturalNumber(String comment) {
        return getNumber(comment, true, -Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public static double getNumberInRange(String comment, double minValue, double maxValue) {
        return getNumber(comment, false, minValue, maxValue);
    }

    public static double getNumberInRange(String comment, double minValue) {
        return getNumber(comment, false, minValue, Double.MAX_VALUE);
    }

    //Основная функция получения числа из консоли
    private static double getNumber(String comment, boolean isNatural, double minValue, double maxValue) {
        print(comment, true);
        Scanner scanner = new Scanner(System.in);
        boolean isDoubleInConsole = scanner.hasNextDouble();
        if (isDoubleInConsole) {
            double value = scanner.nextDouble();
            if (isNatural && value < 1) {
                print("Это не натуральное число! Попробуйте еще раз");
                return getNumber(comment, isNatural, minValue, maxValue);
            } else if (!(value >= minValue && value <= maxValue)) {
                print("Число не входит в допустимый диапазон! Попробуйте еще раз");
                return getNumber(comment, isNatural, minValue, maxValue);
            } else {
                return value;
            }
        }
        print("Ошибка ввода числа! Попробуйте еще раз");
        return getNumber(comment, isNatural, minValue, maxValue);

    }

    public static void print(Object text) {
        System.out.println(text);
    }

    public static void print(Object text, boolean isNotNewLine) {
        if (isNotNewLine) System.out.print(text);
    }

    public static void printOption(int optionNumber, MenuOption option) {
        print(optionNumber + ". " + option.getName());
    }

    public static void printLineDelimiter() {
        print("--------------------------");
    }

    public static void printName(String name, String surname) {
        print("Имя: " + name + "\tФамилия: " + surname);
    }

    public static void printNameWithAge(String name, String surname, int age) {
        print("Имя: " + name + "\tФамилия: " + surname + "\tВозраст: " + age);
    }

    //Функции получения массива из консоли способом на выбор с различными параметрами
    public static double[] getDoubleArrayMenu() {
        return getDoubleArrayMenuBase(0, -Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public static double[] getDoubleArrayMenu(double from, double to) {
        return getDoubleArrayMenuBase(0, from, to);
    }

    public static double[] getDoubleArrayMenu(int arrayInputType, double from, double to) {
        return getDoubleArrayMenuBase(arrayInputType, from, to);
    }

    public static double[] getDoubleArrayMenu(int arrayInputType) {
        return getDoubleArrayMenuBase(arrayInputType, -Double.MAX_VALUE, Double.MAX_VALUE);
    }

    //Основная функция получения массива способом на выбор. Параметр arrayInputType задает метод заполнения
    //Параметры from и to позволяют указать диапазон (значения -/+Double.MAX_VALUE считаются дефолтными)
    private static double[] getDoubleArrayMenuBase(int arrayInputType, double from, double to) {
        boolean isDefaultFrom = from == -Double.MAX_VALUE;
        boolean isDefaultTo = to == Double.MAX_VALUE;
        double randomFromDefault = isDefaultFrom ? 1 : from;
        double randomToDefault = isDefaultTo ? 100 : to;

        double[] arrDouble = new double[(int) ConsoleUtil.getNaturalNumber("Введите размер массива: ")];
        int arrayInputTypeV = arrayInputType == 0 ? (int) getNumberInRange("Заполнение массива\n" + INPUT_ARR_RANDOM + " - случайные числа (от "
                + randomFromDefault + " до " + randomToDefault + "),\n" + INPUT_ARR_MANUAL + " - ручной набор,"
                + "\n" + INPUT_ARR_RANDOM_MANUAL + " - случайные числа в диапазоне\nВыберите: ", 1, 3) : arrayInputType;

        switch (arrayInputTypeV) {
            case INPUT_ARR_RANDOM -> randomizeDoubleArray(arrDouble, randomFromDefault, randomToDefault, 2);
            case INPUT_ARR_MANUAL -> inputDoubleArray(arrDouble, from, to, 2);
            case INPUT_ARR_RANDOM_MANUAL -> {
                Pair range = getTrueRange(from, to);
                randomizeDoubleArray(arrDouble, (double) range.getFirst(), (double) range.getSecond(), (int) getNumberInRange("Знаки после запятой: ", 0));
            }
        }
        return arrDouble;
    }

    //Заполняет переданный массив вводом пользователя
    public static void inputDoubleArray(double[] arrDouble, double from, double to, int roundPlaces) {
        for (int i = 0; i < arrDouble.length; i++) {
            arrDouble[i] = DataUtil.unsafeRoundDouble(getNumberInRange("Введите число в диапазоне от " + from + " до " + to + ": ", from, to), roundPlaces);
        }
    }

    //Заполняет переданный массив рандомом по заданному диапазону
    public static void randomizeDoubleArray(double[] arrDouble, double from, double to, int roundPlaces) {
        for (int i = 0; i < arrDouble.length; i++) {
            arrDouble[i] = DataUtil.getRandomDoubleRounded(from, to, roundPlaces);
        }
    }

    //получение диапазона из консоли
    public static Pair getTrueRange() {
        return getTrueRangeBase(-Double.MAX_VALUE, Double.MAX_VALUE);
    }

    //получение диапазона из консоли с дополнительными границами
    public static Pair getTrueRange(double from, double to) {
        return getTrueRangeBase(from, to);
    }

    //основа получения диапазона из консоли
    private static Pair getTrueRangeBase(double fromLimit, double toLimit) {
        Pair range = new Pair(getNumber("От: "), getNumber("До"));
        if ((double) range.getFirst() >= (double) range.getSecond() || (double) range.getFirst() < fromLimit || (double) range.getSecond() > toLimit) {
            print("Введенный диапазон неправильный! Попробуйте ещё раз.");
            return getTrueRange();
        } else return range;
    }

}
