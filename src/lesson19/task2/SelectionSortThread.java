package lesson19.task2;

import base.ConsoleUtil;

import java.util.Arrays;

public class SelectionSortThread extends Thread {

    private final Double[] array;

    public SelectionSortThread(Double[] array) {
        this.array = array;
    }

    @Override
    public void run() {

        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[maxIndex]) {
                    maxIndex = j;
                }
            }
            Double temp = array[maxIndex];
            array[maxIndex] = array[i];
            array[i] = temp;
        }
        ConsoleUtil.println(this.getClass().getName() + ": " + Arrays.toString(array));

    }

}
