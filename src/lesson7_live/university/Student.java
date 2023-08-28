package lesson7_live.university;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private List<Double> markList;

    private String groupName;

    {
        this.markList = new ArrayList<>();
    }

    public Student(String name, String surname, String groupName) {
        super(name, surname);
        this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<Double> getMarkList() {
        return markList;
    }

    public void addMark(double mark) {
        this.markList.add(mark);
    }

    @Override
    public String toString() {
        return "Студент{" + super.toString() +
                "Список отметок=" + markList +
                ", Группа='" + groupName + '\'' +
                '}';
    }
}
