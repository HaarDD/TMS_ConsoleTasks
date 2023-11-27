package lesson19.task3;

import base.ConsoleUtil;

public class Shop {
    private final int MAX_PRODUCTS = 3;
    private int productCount = 0;

    public synchronized void produce() {
        while (productCount == MAX_PRODUCTS) {
            System.out.println("Максимум товара в магазине!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        productCount++;
        System.out.println("Производитель произвел товар");
        notify();
    }

    public synchronized void consume() {
        while (productCount == 0) {
            System.out.println("Товара в магазине нет!");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        productCount--;
        ConsoleUtil.println("Покупатель купил товар");
        notify();
    }

}
