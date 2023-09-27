package lesson14_extended.university.associations;

import base.ConsoleUtil;
import lesson14_extended.university.persons.Student;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Group {

    private String name;

    private HashSet<Student> studentHashSet;

    private int maxStudentsCount;

    {
        studentHashSet = new HashSet<>();
        maxStudentsCount = 10;
    }

    public Group(String name) {
        this.name = name;
    }

    public void addStudent(Student... students) {
        if (students.length > maxStudentsCount) {
            studentHashSet.addAll(Arrays.stream(students).limit(maxStudentsCount).toList());
            ConsoleUtil.println("При зачислении студентов возникла ошибка, их больше чем мест в группе (" + maxStudentsCount + ')');
        } else {
            studentHashSet.addAll(Arrays.asList(students));
        }
    }

    public void removeStudents(Student... students) {
        Arrays.asList(students).forEach(student -> {
            boolean isRemoved = studentHashSet.remove(student);
            if (!isRemoved) ConsoleUtil.println("Ошибка удаления из группы! Студента  " + student + " нет в группе!");
        });
    }

    public boolean studentContains(Student student) {
        return studentHashSet.contains(student);
    }

    public List<Student> getStudentsList() {
        return studentHashSet.stream().toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(name, group.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Группа (имя: " + name + ", макс. кол-во студентов: " + maxStudentsCount + ", текущее кол-во студентов: " + studentHashSet.size() + ')';
    }
}
