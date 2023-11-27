package lesson19.task2;

import base.ConsoleUtil;

import java.util.Arrays;

public class BubbleSortThread extends Thread {

    private final Double[] array;

    public BubbleSortThread(Double[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    Double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        ConsoleUtil.println(this.getClass().getName() + ": " + Arrays.toString(array));

    }

}
