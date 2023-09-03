package lesson9.task1;

import base.ConsoleUtil;

public class Rabbit extends Animal {

    public Rabbit(String animalName) {
        super(animalName, "Трава");
    }

    @Override
    public void voice() {
        ConsoleUtil.println("Кролик по имени " + this.getName() + " пищит");
    }

    @Override
    public void eat(String food) {
        if (getFavoriteFood().equals(food)) {
            ConsoleUtil.println("Кролик по имени " + this.getName() + " любит травку!");
        } else {
            ConsoleUtil.println("Кролик по имени " + this.getName() + " недоволен и пищит! Он не любит " + food);
        }
    }
}
