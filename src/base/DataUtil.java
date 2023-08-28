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

    public static double getRandomDoubleRounded(Pair range, int roundPlaces) {
        double doubleFrom = (double) range.getFirst();
        double doubleTo = (double) range.getSecond();
        if (doubleTo <= doubleFrom) return 0d;
        return unsafeRoundDouble((random.nextDouble() * (doubleTo - doubleFrom) + doubleFrom), roundPlaces);
    }

    public static double unsafeRoundDouble(double value, double roundPlaces) {
        double scale = Math.pow(10, roundPlaces);
        return Math.round(value * scale) / scale;
    }

    public static double[] revertArray(double[] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            double temp = array[i];
            array[i] = array[length - 1 - i];
            array[length - 1 - i] = temp;
        }
        return array;
    }

    public static double getMaxMinNumberInArray(Object[] array, findMaxMinOperation operation) {
        double max = Double.NEGATIVE_INFINITY;
        for (Object o : array) {
            if (o instanceof Object[]) {
                double maxNumberInArray = getMaxMinNumberInArray((Object[]) o, operation);
                if (operation.compare(max, maxNumberInArray)) {
                    max = maxNumberInArray;
                }
            } else {
                if (operation.compare(max, (double) o)) {
                    max = (double) o;
                }
            }
        }
        return max;
    }

    public static void modificationSpecificNumbersInArray(Object[] array, modificationDoubleOperation operation) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] instanceof Object[]) {
                modificationSpecificNumbersInArray((Object[]) array[i], operation);
            } else {
                array[i] = operation.getNewValue((double) array[i]);
            }
        }
    }

    public static double sumNumbersMultiArray(Object[] array) {
        double sum = 0;
        for (Object o : array) {
            if (o instanceof Object[]) {
                sum += sumNumbersMultiArray((Object[]) o);
            } else {
                sum += (double) o;
            }
        }
        return sum;
    }


    public static int lengthOfMultiArray(Object array) {
        if (array instanceof Object[]) {
            int totalLength = 0;
            for (Object element : (Object[]) array) {
                totalLength += lengthOfMultiArray(element);
            }
            return totalLength;
        } else {
            return 1;
        }
    }

    public interface findMaxMinOperation {
        boolean compare(double a, double b);
    }

    public interface modificationDoubleOperation {
        double getNewValue(double value);
    }
}
