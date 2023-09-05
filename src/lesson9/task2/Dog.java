package lesson9.task2;

import base.ConsoleUtil;

public class Dog {

    private static Dog DOG;
    private final String favoriteFood;
    private String name;

    {
        this.name = "Барсик";
        this.favoriteFood = "Мясо";
    }

    private Dog() {
    }

    public static Dog getDogInstance() {
        if (DOG == null) {
            DOG = new Dog();
        }
        return DOG;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void voice() {
        ConsoleUtil.println("Собака по имени " + this.getName() + " лает");
    }

    public void eat(String food) {
        if (getFavoriteFood().equals(food)) {
            ConsoleUtil.println("Собака по имени " + this.getName() + " любит мясо!");
        } else {
            ConsoleUtil.println("Собака по имени " + this.getName() + " недовольна и скулит! Она не любит " + food);
        }
    }
}

