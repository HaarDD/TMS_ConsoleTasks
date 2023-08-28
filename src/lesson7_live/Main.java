package lesson7_live;

import base.ConsoleUtil;
import lesson7_live.university.Student;
import lesson7_live.university.Teacher;
import lesson7_live.university.University;

public class Main {
    public static void main(String[] args) {

        University university = new University("г. Минск");

        Student student = new Student("Максим", "Галицкий", "c-24");

        student.addMark(10);

        university.addStudent(student);

        university.addEmployee(new Teacher("Вячеслав", "Мухин", "Java WEB-сервисы"));

        ConsoleUtil.println(university);

    }
}
