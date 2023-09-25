package lesson13.task2;

import java.util.Arrays;
import java.util.LinkedList;

public class AnimalsList {
    private final LinkedList<String> animals;

    {
        animals = new LinkedList<>();
    }

    public void addAnimal(String animalName) {
        animals.addFirst(animalName);
    }

    public void removeAnimal() {
        if (!animals.isEmpty()) animals.removeLast();
    }

    @Override
    public String toString() {
        return Arrays.toString(animals.toArray());
    }
}
