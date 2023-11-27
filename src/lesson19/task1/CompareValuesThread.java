package lesson19.task1;

public class CompareValuesThread<T extends Number> extends Thread {
    private final T[] array;
    private final ComparisonFunction<T> comparisonFunction;
    private T result;

    public CompareValuesThread(T[] array, ComparisonFunction<T> comparisonFunction) {
        this.array = array;
        this.comparisonFunction = comparisonFunction;
    }

    @Override
    public void run() {
        T max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (comparisonFunction.compare(array[i], max)) {
                max = array[i];
            }
        }
        this.result = max;
    }

    public T getResult() {
        return result;
    }

    @FunctionalInterface
    public interface ComparisonFunction<T extends Number> {
        boolean compare(T a, T b);
    }
}
