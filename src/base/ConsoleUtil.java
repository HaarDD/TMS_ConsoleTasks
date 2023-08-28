package base;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.DoubleStream;

public class ConsoleUtil {
    //константы для определения типов ввода массива


    public static final int DEFAULT_VALUE = 0;
    public static final int INPUT_ARR_RANDOM = 1;
    public static final int INPUT_ARR_MANUAL = 2;
    public static final int INPUT_ARR_RANDOM_MANUAL = 3;

    public static final int MULTI_ARRAY_TYPE_JAGGED = 2;

    public static final int MULTI_ARRAY_TYPE_USUAL = 1;

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
        print(comment);
        Scanner scanner = new Scanner(System.in);
        boolean isDoubleInConsole = scanner.hasNextDouble();
        if (isDoubleInConsole) {
            double value = scanner.nextDouble();
            if (isNatural && value < 1) {
                println("Это не натуральное число! Попробуйте еще раз");
                return getNumber(comment, isNatural, minValue, maxValue);
            } else if (!(value >= minValue && value <= maxValue)) {
                println("Число не входит в допустимый диапазон! Попробуйте еще раз");
                return getNumber(comment, isNatural, minValue, maxValue);
            } else {
                return value;
            }
        }
        println("Ошибка ввода числа! Попробуйте еще раз");
        return getNumber(comment, isNatural, minValue, maxValue);

    }

    public static void println(Object text) {
        System.out.println(text);
    }

    public static void println() {
        System.out.println();
    }

    public static void print(Object text) {
        System.out.print(text);
    }

    public static void printOption(int optionNumber, MenuOption option) {
        println(optionNumber + ". " + option.getName());
    }

    public static void printLineDelimiter() {
        println("----------------------------------------------");
    }

    public static void printName(String name, String surname) {
        println("Имя: " + name + "\tФамилия: " + surname);
    }

    public static void printNameWithAge(String name, String surname, int age) {
        println("Имя: " + name + "\tФамилия: " + surname + "\tВозраст: " + age);
    }

    public static void printIntMatrix(int[][] array, int columnSpaces) {
        for (int[] row : array) {
            for (int cell : row) {
                String value = Integer.toString(cell);
                print(value + " ".repeat(Math.max(columnSpaces - value.length(), 0)) + " ");
            }
            println();
        }
    }

    public static void printStringMatrix(String[][] array, int columnSpaces) {
        for (String[] row : array) {
            for (String cell : row) {
                print(cell + " ".repeat(Math.max(columnSpaces - cell.length(), 0)) + " ");
            }
            println();
        }
    }

    //Функции получения массива из консоли способом на выбор с различными параметрами
    public static double[] getDoubleArrayMenu() {
        return getDoubleArray(DEFAULT_VALUE, DEFAULT_VALUE, new Pair(-Double.MAX_VALUE, Double.MAX_VALUE));
    }

    public static double[] getDoubleArrayMenu(double from, double to) {
        return getDoubleArray(DEFAULT_VALUE, DEFAULT_VALUE, new Pair(from, to));
    }

    public static double[] getDoubleArrayMenu(int defaultInputMethod, double from, double to) {
        return getDoubleArray(DEFAULT_VALUE, defaultInputMethod, new Pair(from, to));
    }

    public static double[] getDoubleArrayMenu(int defaultInputMethod) {
        return getDoubleArray(DEFAULT_VALUE, defaultInputMethod, new Pair(-Double.MAX_VALUE, Double.MAX_VALUE));
    }

    //Основная функция получения массива способом на выбор. Параметр arrayInputType задает метод заполнения
    //Параметры from и to позволяют указать диапазон (значения -/+Double.MAX_VALUE считаются дефолтными)

    private static double[] getDoubleArray(int defaultLength, int defaultInputMethod, Pair defaultRange) {
        double from = (double) defaultRange.getFirst();
        double to = (double) defaultRange.getSecond();

        Pair randomExtremeRange = new Pair(from == -Double.MAX_VALUE ? 1 : from, to == Double.MAX_VALUE ? 100 : to);

        int length = defaultLength == DEFAULT_VALUE ? (int) ConsoleUtil.getNumberInRange("Введите размер массива: ", 2, 100) : defaultLength;

        int arrayInputTypeV = defaultInputMethod == DEFAULT_VALUE ? getArrayInputMethod(randomExtremeRange) : defaultInputMethod;

        switch (arrayInputTypeV) {
            case INPUT_ARR_RANDOM -> {//ввод рандомом
                return generateRandomDoubleArray(length, randomExtremeRange, 2);
            }
            case INPUT_ARR_MANUAL -> {//ввод вручную
                return enterDoubleArray(length, from, to, 2);
            }
            case INPUT_ARR_RANDOM_MANUAL -> {//ввод контролируемым рандомом
                Pair randomRange = getTrueRange(from, to);//ввод диапазона
                return generateRandomDoubleArray(length, randomRange, (int) getNumberInRange("Знаки после запятой: ", 0));
            }
            default -> {
                return new double[length];
            }
        }
    }

    private static int getArrayInputMethod(Pair randomExtremeRange) {
        return (int) getNumberInRange("Заполнение массива\n" + INPUT_ARR_RANDOM + " - случайные числа (от "
                + randomExtremeRange.getFirst() + " до " + randomExtremeRange.getSecond() + "),\n" + INPUT_ARR_MANUAL + " - ручной набор,"
                + "\n" + INPUT_ARR_RANDOM_MANUAL + " - случайные числа в диапазоне\nВыберите: ", 1, 3);
    }

    //Функции получения массива из консоли способом на выбор с различными параметрами
    public static Object[] getMultiArray() {
        return getMultiArrayBase(DEFAULT_VALUE, DEFAULT_VALUE, new Pair(-Double.MAX_VALUE, Double.MAX_VALUE), (int) ConsoleUtil.getNumberInRange("Введите уровень вложенности: ", 2));
    }

    public static Object[] getMultiArrayWithParameters(int defaultLength, int defaultInputMethod, Pair defaultRange, int nesting) {
        return getMultiArrayBase(defaultLength, defaultInputMethod, defaultRange, nesting);
    }


    private static Object[] getMultiArrayBase(int defaultUsualMultiArrayLength, int defaultInputMethod, Pair defaultRange, int nesting) {
        int length = defaultUsualMultiArrayLength == DEFAULT_VALUE ? (int) ConsoleUtil.getNumberInRange("Введите размер массива уровня " + nesting + ": ", 2, 100) : defaultUsualMultiArrayLength;

        int trueInputMethod = defaultInputMethod;
        if (trueInputMethod == DEFAULT_VALUE) {
            int eachArraySameInputMethod = (int) getNumberInRange("""
                    Выберите метод заполнения (
                    1 - общий для всех массивов,
                    2 - отдельный для каждого массива):\s""", 1, 2);
            trueInputMethod = eachArraySameInputMethod == 1 ? getArrayInputMethod(defaultRange) : defaultInputMethod;
        }

        Object[] objectArray = new Object[length];
        if (nesting == 1) {
            objectArray = convertDoubleToObjectArray(getDoubleArray(length, defaultInputMethod, defaultRange));
        } else {
            println("Уровень " + (nesting - 1));
            int multiArrayType = defaultUsualMultiArrayLength != DEFAULT_VALUE ? MULTI_ARRAY_TYPE_USUAL : getMultiArrayType();
            if (multiArrayType == MULTI_ARRAY_TYPE_USUAL) {
                for (int i = 0; i < objectArray.length; i++) {
                    //print("Массив " + (i + 1));
                    objectArray[i] = getMultiArrayBase(length, trueInputMethod, defaultRange, nesting - 1);
                }
            } else if (multiArrayType == MULTI_ARRAY_TYPE_JAGGED) {
                for (int i = 0; i < objectArray.length; i++) {
                    //print("Массив " + (i + 1));
                    objectArray[i] = getMultiArrayBase(DEFAULT_VALUE, defaultInputMethod, defaultRange, nesting - 1);
                }
            }
        }
        return objectArray;
    }

    private static int getMultiArrayType() {
        return (int) getNumberInRange("Выберите вид массивов (" + MULTI_ARRAY_TYPE_USUAL + " - ровный, "
                + MULTI_ARRAY_TYPE_JAGGED + " - зубчатый): ", MULTI_ARRAY_TYPE_USUAL, MULTI_ARRAY_TYPE_JAGGED);
    }


    private static double[] arrayToDouble(Object[] array) {
        return Arrays.stream(array).mapToDouble(value -> (Double) value).toArray();
    }

    public static Object[] convertDoubleToObjectArray(double[] doubleArray) {
        return DoubleStream.of(doubleArray).boxed().toArray();
    }

    //Создает и заполняет массив из консоли для каждого числа
    public static double[] enterDoubleArray(int length, double from, double to, int roundPlaces) {
        double[] array = new double[length];
        for (int i = 0; i < length; i++) {
            array[i] = DataUtil.unsafeRoundDouble(getNumberInRange("Введите число в диапазоне " + ((from == -Double.MAX_VALUE) ? "" : "от " + from)
                    + ((to == Double.MAX_VALUE) ? "" : " до " + to) + ": ", from, to), roundPlaces);
        }
        return array;
    }

    //Создает и заполняет массив рандомом по заданному диапазону
    public static double[] generateRandomDoubleArray(int length, Pair range, int roundPlaces) {
        double[] arrDouble = new double[length];
        for (int i = 0; i < arrDouble.length; i++) {
            arrDouble[i] = DataUtil.getRandomDoubleRounded(range, roundPlaces);
        }
        return arrDouble;
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
            println("Введенный диапазон неправильный! Попробуйте ещё раз.");
            return getTrueRange();
        } else return range;
    }

}
