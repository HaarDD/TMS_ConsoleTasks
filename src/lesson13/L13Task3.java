package lesson13;

import base.ConsoleUtil;
import base.Runnable;
import lesson13.task3.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/*Задача 3:
Создать класс Student, содержащий следующие характеристики – имя, группа, курс,
оценки по предметам. Создать коллекцию, содержащую объекты класса Student.
Написать метод, который удаляет студентов со средним баллом <3. Если средний
балл>=3, студент переводится на следующий курс. Дополнительно написать метод
printStudents(List<Student> students, int course), который получает список студентов и
номер курса. А также печатает на консоль имена тех студентов из списка, которые
обучаются на данном курсе.*/
public class L13Task3 extends Runnable {

    public L13Task3() {
        super("Класс Student");
    }

    @Override
    public void run() {
        List<Student> studentsList = new ArrayList<>();

        studentsList.add(new Student("Иванов", "1", 1, 2, 3, 6, 7, 8, 9));
        studentsList.add(new Student("Петров", "2", 3, 3, 3, 4, 2, 1, 2));
        studentsList.add(new Student("Сидоров", "1", 2, 4, 5, 6, 3, 8, 9));

        ConsoleUtil.println("Список студентов:");
        printStudents(studentsList);

        nextCourseTransfer(studentsList);

        ConsoleUtil.println("Список студентов, прошедших на следующие курсы:");
        printStudents(studentsList);

        ConsoleUtil.println("Список студентов второго курса: ");
        printStudents(studentsList, 2);
    }

    public void nextCourseTransfer(List<Student> studentsList) {
        Iterator<Student> iterator = studentsList.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverageMark() < 3) {
                iterator.remove();
            } else {
                student.incrementCourse();
            }
        }
    }

    public void printStudents(List<Student> studentsList) {
        ConsoleUtil.println(studentsList.stream().collect(StringBuilder::new, (stringBuilder, str) -> stringBuilder.append(str).append('\n'), StringBuilder::append));
    }

    public void printStudents(List<Student> studentsList, int course) {
        List<Student> filteredStudentsByCourse = studentsList.stream().filter(student -> student.getCourse() == course).toList();
        if (filteredStudentsByCourse.size() != 0) {
            printStudents(filteredStudentsByCourse);
        } else {
            ConsoleUtil.println("Студентов такого курса нет!");
        }
    }


}
