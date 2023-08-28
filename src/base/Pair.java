package base;

public class Pair {
    private final Number first;
    private final Number second;

    public Pair(Number from, Number second) {
        this.first = from;
        this.second = second;
    }

    public Number getFirst() {
        return first;
    }

    public Number getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "[" + this.first + ", " + this.second + "]";
    }
}

