package lesson13.task3;

import base.DataUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class Student {

    private final List<Integer> marksList;
    private String name;
    private String group;
    private int course;

    {
        marksList = new ArrayList<>();
    }

    public Student(String name, String group, int course) {
        this.name = name;
        this.group = group;
        this.course = course;
    }

    public Student(String name, String group, int course, int... marks) {
        this(name, group, course);
        for (int mark : marks) {
            addMarks(mark);
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void incrementCourse() {
        this.course++;
    }

    public void addMarks(Number... marks) {
        for (Number mark : marks) {
            this.marksList.add((int) mark);
        }
    }

    public void clearMarks() {
        this.marksList.clear();
    }

    public Double getAverageMark() {
        OptionalDouble average = this.marksList.stream().mapToInt(value -> value).average();
        return average.isPresent() ? average.getAsDouble() : null;
    }

    @Override
    public String toString() {
        return "Студент: " + name + " Группа: " + group + " Курс: " + course + " Отметки: " + Arrays.toString(marksList.toArray()) + " Средний балл: " + DataUtil.unsafeRoundDouble(getAverageMark(), 2);
    }
}
