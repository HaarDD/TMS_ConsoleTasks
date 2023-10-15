package lesson19;

import base.TaskRunnable;
import lesson19.task3.Consumer;
import lesson19.task3.Producer;
import lesson19.task3.Shop;

/*Задача *:
Имеются сущности Магазин, Производитель, Покупатель. Цель задачи сделать так чтобы
производитель произвел 5 единиц продукта, а покупатель их купил. Пока производитель
не произвел продукт, покупатель не может его купить. При этом одновременно в магазине
может находиться не более 3 товаров*/
public class L19Task3 extends TaskRunnable {


    public L19Task3() {
        super("Магазин");
    }

    @Override
    public void runTask() {
        Shop shop = new Shop();
        Producer producer = new Producer(shop);
        Consumer consumer = new Consumer(shop);

        producer.start();
        consumer.start();

        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        producer.interrupt();
        consumer.interrupt();
    }
}
