package base;

public class Pair {
    private Number first;
    private Number second;

    public Pair(Number first, Number second) {
        this.first = first;
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

