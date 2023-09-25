package lesson14_extended.university.persons;

import lesson14_extended.university.associations.Group;
import lesson14_extended.university.real_estates.StudentAddressable;

import java.util.Objects;

public class Student extends Person {

    StudentAddressable studentAddressable;
    private Group group;

    public Student(String firstName, String lastName, String patronymic, Group group, StudentAddressable studentAddressable) {
        super(firstName, lastName, patronymic);
        this.group = group;
        group.addStudent(this);
        this.studentAddressable = studentAddressable;
    }

    public StudentAddressable getStudentAddressable() {
        return studentAddressable;
    }

    public void setStudentAddressable(StudentAddressable studentAddressable) {
        this.studentAddressable = studentAddressable;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(group, student.group) && Objects.equals(getFirstName(), student.getFirstName())
                && Objects.equals(getLastName(), student.getLastName()) && Objects.equals(getPatronymic(), student.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), group, getFirstName(), getLastName(), getPatronymic());
    }

    @Override
    public String toString() {
        return "Студент " + super.toString() + ", группа: " + group + ", адрес: " + getStudentAddressable().getAddressString();
    }
}