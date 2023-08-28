package lesson7_live.university;

public class Employee extends Person {
    public Employee(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return "Работник{" + super.toString() + "}";
    }
}