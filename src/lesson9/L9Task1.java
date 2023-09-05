package lesson9;

import base.Runnable;
import lesson9.task1.Animal;
import lesson9.task1.Dog;
import lesson9.task1.Rabbit;
import lesson9.task1.Tiger;


/*Задача 1:
Создать логически верную иерархию следующих классов: Animal, Dog, Tiger, Rabbit.
Переопределить методы voice(), eat(String food) чтобы они выводили верную
информацию. Метод eat может принимать “Meat”, “Grass” и другие строки.

Например, если мы создадим объект класса Rabbit, вызовем метод eat() и передадим
туда “Grass” он должен написать в консоли, что любит есть травку. Если передадим “Meat”
или другую строку, то он будет недоволен*/
public class L9Task1 extends Runnable {

    public L9Task1() {
        super("Иерархия классов Animal, Dog, Tiger, Rabbit");
    }

    @Override
    public void run() {
        Dog dog = new Dog("Мухтар");
        Rabbit rabbit = new Rabbit("Роберт");
        Tiger tiger = new Tiger("Диего");

        for (Animal animal : new Animal[]{dog, rabbit, tiger}) {
            animal.eat("Мясо");
        }

        rabbit.eat("Трава");


    }

}
