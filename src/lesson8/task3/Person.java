package lesson8.task3;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Person implements Cloneable {

    private final GregorianCalendar birthday;
    private String name;
    private String surname;
    private String patronymic;

    {
        birthday = new GregorianCalendar();
    }

    public Person(String surname, String name, String patronymic, int day, int month, int year) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        setBirthday(day, month, year);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setBirthday(int day, int month, int year) {
        birthday.set(GregorianCalendar.DAY_OF_MONTH, day);
        birthday.set(GregorianCalendar.MONTH, month);
        birthday.set(GregorianCalendar.YEAR, year);
    }

    @Override
    public String toString() {
        return "(" + surname + " " + name + " " + patronymic + " " + birthday.get(Calendar.DAY_OF_MONTH) + "." + birthday.get(Calendar.MONTH) + "." + birthday.get(Calendar.YEAR) + ")";
    }

    //Task3*
    @Override
    public Person clone() {
        try {
            Person clone = (Person) super.clone();
            clone.setName(getName());
            clone.setSurname(getSurname());
            clone.setPatronymic(getPatronymic());
            clone.setBirthday(birthday.get(Calendar.DAY_OF_MONTH), birthday.get(Calendar.MONTH), birthday.get(Calendar.YEAR));
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
