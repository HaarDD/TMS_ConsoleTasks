package lesson9.task1;

import base.ConsoleUtil;

public class Dog extends Animal {

    public Dog(String animalName) {
        super(animalName, "Мясо");
    }

    @Override
    public void voice() {
        ConsoleUtil.println("Собака по имени " + this.getName() + " лает");
    }

    @Override
    public void eat(String food) {
        if (getFavoriteFood().equals(food)) {
            ConsoleUtil.println("Собака по имени " + this.getName() + " любит мясо!");
        } else {
            ConsoleUtil.println("Собака по имени " + this.getName() + " недовольна и скулит! Она не любит " + food);
        }
    }
}
