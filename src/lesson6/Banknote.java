package lesson6;

public class Banknote {
    private final int banknote;
    protected int count;

    public Banknote(int banknote, int count) {
        this.banknote = banknote;
        this.count = count;
    }

    public int getBanknote() {
        return banknote;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "[" + banknote + "руб., " + count + "шт.]";
    }
}
