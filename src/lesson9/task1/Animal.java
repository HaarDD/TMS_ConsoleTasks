package lesson9.task1;

public abstract class Animal {

    private final String name;
    private final String favoriteFood;

    Animal(String name, String favoriteFood) {
        this.name = name;
        this.favoriteFood = favoriteFood;
    }

    public String getName() {
        return name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public abstract void voice();

    public abstract void eat(String food);


}
