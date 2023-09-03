package lesson9.task1;

import base.ConsoleUtil;

public class Tiger extends Animal {

    public Tiger(String animalName) {
        super(animalName, "Мясо");
    }

    @Override
    public void voice() {
        ConsoleUtil.println("Тигр по имени " + this.getName() + " рычит");
    }

    @Override
    public void eat(String food) {
        if (getFavoriteFood().equals(food)) {
            ConsoleUtil.println("Тигр по имени " + this.getName() + " любит мясо!");
        } else {
            ConsoleUtil.println("Тигр по имени " + this.getName() + " недоволен и рычит! Он не любит " + food);
        }
    }
}
