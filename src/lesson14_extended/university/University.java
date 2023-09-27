package lesson14_extended.university;

import base.ConsoleUtil;
import base.Runnable;
import lesson14_extended.university.associations.Group;
import lesson14_extended.university.persons.Employee;
import lesson14_extended.university.persons.Person;
import lesson14_extended.university.persons.Student;
import lesson14_extended.university.real_estates.Dormitory;
import lesson14_extended.university.real_estates.OwnHousing;
import lesson14_extended.university.real_estates.Room;
import lesson14_extended.university.real_estates.StudentAddressable;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class University extends Runnable {

    private final HashSet<Student> studentHashSet;

    private final HashSet<Employee> employeeHashSet;

    private final HashSet<Dormitory> dormitoryHashSet;

    private final HashSet<Group> groupHashSet;


    {
        studentHashSet = new HashSet<>();
        employeeHashSet = new HashSet<>();
        dormitoryHashSet = new HashSet<>();
        groupHashSet = new HashSet<>();

        Dormitory dormitory1 = new Dormitory("Общежитие №1", "Мясникова12");
        dormitory1.addRooms(new Room(1, dormitory1, 2), new Room(2, dormitory1));

        groupHashSet.add(new Group("10"));


        dormitoryHashSet.add(dormitory1);
    }

    public University() {
        super("Университет");
    }

    private void addEmployee(Employee... employees) {
        employeeHashSet.addAll(Arrays.asList(employees));
    }

    private void removeEmployee(Employee... employees) {
        Arrays.asList(employees).forEach(employeeHashSet::remove);
    }

    private List<Employee> findEmployeesByFullName(String firstName, String lastName, String patronymic) {
        return employeeHashSet.stream().filter(employee -> Objects.equals(employee.getFirstName(), firstName)
                && Objects.equals(employee.getLastName(), lastName) && Objects.equals(employee.getPatronymic(), patronymic)).toList();
    }

    private void printEmployeeList() {
        ConsoleUtil.println(objectsToStringList(Collections.singleton(employeeHashSet)));
    }

    private void addStudents(Student... students) {
        studentHashSet.addAll(Arrays.asList(students));
    }

    private void addStudentConsole() {
        Student student = new Student(ConsoleUtil.getString("Имя: "), ConsoleUtil.getString("Фамилия: "), ConsoleUtil.getString("Отчество: "),
                selectObjectConsole(groupHashSet), selectOrNewStudentAddressableConsole());
        boolean isAdded = studentHashSet.add(student);
        ConsoleUtil.println(isAdded ? "Студент добавлен!" : "Не удалось добавить студента!");
    }

    private void addEmployeeConsole() {
        Employee employee = new Employee(ConsoleUtil.getString("Имя: "), ConsoleUtil.getString("Фамилия: "), ConsoleUtil.getString("Отчество: "),
                ConsoleUtil.getString("Должность: "));
        boolean isAdded = employeeHashSet.add(employee);
        ConsoleUtil.println(isAdded ? "Работник добавлен!" : "Не удалось добавить работника!");
    }


    private <T> T selectObjectConsole(Collection<T> objects) {
        ConsoleUtil.println(objectsToStringList(Collections.singleton(objects)));
        int selected = (int) ConsoleUtil.getNumberInRange("Выберите объект: ", 1, objects.size()) - 1;
        return objects.stream().toList().get(selected);
    }

    private StudentAddressable selectOrNewStudentAddressableConsole() {
        ConsoleUtil.println("Выбор места проживания:\n1. Собственное жилье\n2. Заселить в общежитие");
        switch ((int) ConsoleUtil.getNumberInRange("Выберите пункт: ", 1, 2)) {
            case 1 -> {
                return new OwnHousing(ConsoleUtil.getString("Введите адрес: "));
            }
            case 2 -> {
                Room firstNonFilledRoom = selectObjectConsole(dormitoryHashSet).getFirstNonFilledRoom();
                return Objects.requireNonNullElseGet(firstNonFilledRoom, this::selectOrNewStudentAddressableConsole);
            }
            default -> {
                ConsoleUtil.println("Функции под таким номером нет");
                return selectOrNewStudentAddressableConsole();
            }
        }
    }


    private Student findStudentByFullName(String firstName, String lastName, String patronymic) {
        return findPersonByFullName(studentHashSet, firstName, lastName, patronymic);
    }

    private Employee findEmployeeByFullName(String firstName, String lastName, String patronymic) {
        return findPersonByFullName(employeeHashSet, firstName, lastName, patronymic);
    }


    private <T extends Person> T findPersonByFullNameConsole(Collection<T> personCollection) {
        return findPersonByFullName(personCollection, ConsoleUtil.getString("Имя: "), ConsoleUtil.getString("Фамилия: "), ConsoleUtil.getString("Отчество: "));
    }

    private <T extends Person> T findPersonByFullName(Collection<T> personCollection, String firstName, String lastName, String patronymic) {
        return personCollection.stream().filter(student -> Objects.equals(student.getFirstName(), firstName)
                        && Objects.equals(student.getLastName(), lastName) && Objects.equals(student.getPatronymic(), patronymic))
                .findFirst().orElse(null);
    }


    private void removeStudent(Student... students) {
        Arrays.asList(students).forEach(studentHashSet::remove);
    }

    private void addStudentToDormitory(Student student) {
        for (Dormitory dormitory : dormitoryHashSet) {
            Room firstNonFilledRoom = dormitory.getFirstNonFilledRoom();
            if (firstNonFilledRoom == null) {
                continue;
            }
            firstNonFilledRoom.addStudent(student);
            student.setStudentAddressable(firstNonFilledRoom);
            ConsoleUtil.println("Студент заселен по адресу " + dormitory.getAddress() + " в комнату " + firstNonFilledRoom.getRoom());
            return;
        }
        ConsoleUtil.println("Свободных общежитий нет!");
    }

    private void printStudentsList() {
        ConsoleUtil.println(objectsToStringList(Collections.singleton(studentHashSet)));
    }


    private String objectsToStringList(Collection<Object> objects) {
        AtomicInteger counter = new AtomicInteger(1);
        return objects.stream().map(object -> counter.getAndIncrement() + ". " + object).map(String::trim).collect(Collectors.joining("\n"));
    }


    @Override
    public void run() {
        final int ADD_STUDENT = 1;
        final int ADD_EMPLOYEE = 2;
        final int ADD_STUDENT_TO_DORMITORY = 3;
        final int PRINT_ALL_STUDENTS = 4;
        final int PRINT_ALL_EMPLOYEES = 5;
        final int EXIT_UNIVERSITY_MENU = 0;

        int selected = -1;
        while (selected != EXIT_UNIVERSITY_MENU) {
            ConsoleUtil.printLineDelimiter();
            ConsoleUtil.println(ADD_STUDENT + ". Добавить студента\n"
                    + ADD_EMPLOYEE + ". Добавить работника\n"
                    + ADD_STUDENT_TO_DORMITORY + ". Заселить студента\n"
                    + PRINT_ALL_STUDENTS + ". Отобразить всех студентов\n"
                    + PRINT_ALL_EMPLOYEES + ". Отобразить всех работников\n"
                    + EXIT_UNIVERSITY_MENU + ". Выход");
            selected = (int) ConsoleUtil.getNumberInRange("Выберите пункт: ", EXIT_UNIVERSITY_MENU, PRINT_ALL_EMPLOYEES);
            switch (selected) {
                case ADD_STUDENT -> addStudentConsole();
                case ADD_EMPLOYEE -> addEmployeeConsole();
                case ADD_STUDENT_TO_DORMITORY -> {
                    Student student = findPersonByFullNameConsole(studentHashSet);
                    if (student == null) {
                        ConsoleUtil.println("Студент не найден!");
                    } else {
                        addStudentToDormitory(student);
                    }

                }
                case PRINT_ALL_STUDENTS -> printStudentsList();
                case PRINT_ALL_EMPLOYEES -> printEmployeeList();
                case EXIT_UNIVERSITY_MENU -> ConsoleUtil.println("Выход...");
                default -> ConsoleUtil.println("Функции под таким номером нет (" + selected + ')');
            }
        }


    }
}
