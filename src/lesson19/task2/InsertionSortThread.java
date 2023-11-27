package lesson19.task2;

import base.ConsoleUtil;

import java.util.Arrays;

public class InsertionSortThread extends Thread {

    private final Double[] array;

    public InsertionSortThread(Double[] array) {
        this.array = array;
    }

    @Override
    public void run() {
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0 && array[j - 1] > array[j]; j--) {
                Double temp = array[j];
                array[j] = array[j - 1];
                array[j - 1] = temp;
            }
        }
        ConsoleUtil.println(this.getClass().getName() + ": " + Arrays.toString(array));
    }

}
