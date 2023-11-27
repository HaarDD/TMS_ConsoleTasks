package lesson19.task3;

public class Consumer extends Thread {
    private final Shop shop;

    public Consumer(Shop shop) {
        this.shop = shop;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            shop.consume();
        }
    }
}
