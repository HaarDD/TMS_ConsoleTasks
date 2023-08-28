package lesson4;

import base.ConsoleUtil;
import base.Runnable;

import java.util.Arrays;

/*Задача *:
Имеется массив из неотрицательных чисел(любой). Представьте что массив
представляет целое число (Например массив {1,2,3} -> 123, {9,9,9} -> 999). Задача
добавить единицу к этому “числу” и на выходе получить исправленный массив. Массив не
содержит нуля в начале, кроме самого числа 0.
Пример:
Input: [1,4,0,5,6,3]
Output: [1,4,0,5,6,4]
Input: [9,9,9]
Output: [1,0,0,0]*/
public class L4Task5 extends Runnable {

    public L4Task5() {
        super("Инкремент числа в виде массива");
    }

    @Override
    public void run() {
        final int STRING_METHOD = 1;
        final int LOG_METHOD = 2;

        ConsoleUtil.println("Примечание: все 0 в начале массива будут удалены");
        int[] array = Arrays.stream(ConsoleUtil.getDoubleArrayMenu(ConsoleUtil.INPUT_ARR_MANUAL, 0, 9)).mapToInt(value -> (int) value).toArray();

        int zerosFromStart = 0;
        for (int i : array) {
            if (i == 0) {
                zerosFromStart++;
            } else break;
        }
        array = Arrays.copyOfRange(array, zerosFromStart, array.length);

        if (array.length == 0) {
            ConsoleUtil.println("Массив пустой.");
            return;
        }

        int method = (int) ConsoleUtil.getNumberInRange("Выберите метод (" + STRING_METHOD + "  - через String," +
                " " + LOG_METHOD + " - деление/умножение): ", STRING_METHOD, LOG_METHOD);

        ConsoleUtil.println(Arrays.toString(array));

        switch (method) {
            case STRING_METHOD -> {
                StringBuilder valueText = new StringBuilder();
                for (int i : array) {
                    valueText.append(i);
                }
                int value = Integer.parseInt(valueText.toString()) + 1;
                int[] newArrayS = new StringBuilder(String.valueOf(value)).chars().map(digit -> digit - (int) '0').toArray();
                ConsoleUtil.println(Arrays.toString(newArrayS));
            }
            case LOG_METHOD -> {
                int number = 0;
                for (int i = 0; i < array.length; i++) {
                    number += array[i] * Math.pow(10, array.length - i - 1);
                }
                number++;
                int digitsCount = (int) Math.log10(number) + 1;
                int[] newArrayD = new int[digitsCount];
                for (int i = digitsCount - 1; number > 0; i--) {
                    newArrayD[i] = number % 10;
                    number /= 10;
                }
                ConsoleUtil.println(Arrays.toString(newArrayD));
            }

        }

    }

}
