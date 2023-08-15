package base;

import java.util.Random;

public class DataUtil {

    private static final Random random = new Random();

    public static String[] randomizeStringArray(String[] inputArray) {
        return randomizeStringArrayBase(inputArray, inputArray.length);
    }

    public static String[] randomizeStringArray(String[] inputArray, int resultWordCount) {
        return randomizeStringArrayBase(inputArray, resultWordCount < 1 ? 1 : Math.min(resultWordCount, inputArray.length));
    }

    public static String randomStringArrayValue(String[] inputArray) {
        return randomizeStringArrayBase(inputArray, 1)[0];
    }

    private static String[] randomizeStringArrayBase(String[] inputArray, int resultWordCount) {
        String[] stringArray = new String[resultWordCount];

        for (int i = 0; i < resultWordCount; i++) {
            int j = random.nextInt(resultWordCount - i);
            stringArray[i] = inputArray[j];

            String temp = inputArray[j];
            inputArray[j] = inputArray[inputArray.length - 1 - i];
            inputArray[inputArray.length - 1 - i] = temp;
        }
        return stringArray;
    }

    public static double getRandomDoubleRounded(double from, double to, double roundPlaces) {
        if (to <= from) return 0d;
        return unsafeRoundDouble((random.nextDouble() * (to - from) + from), roundPlaces);
    }

    public static double unsafeRoundDouble(double value, double roundPlaces) {
        double scale = Math.pow(10, roundPlaces);
        return Math.round(value * scale) / scale;
    }

    public static double[] revertArray(double[] array) {
        int length = array.length;
        double[] tempArray = new double[length];
        for (int i = 0; i < length; i++) {
            tempArray[i] = array[length - 1 - i];
        }
        return tempArray;
    }


}
