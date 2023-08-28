package lesson7_live.university;

import java.util.ArrayList;
import java.util.List;

public class University {

    private List<Student> studentList;

    private List<Employee> employeeList;

    private String address;

    {
        studentList = new ArrayList<>();
        employeeList = new ArrayList<>();
    }

    public University(String address) {
        this.address = address;
    }

    public void addStudent(Student student) {
        this.studentList.add(student);
    }

    public void addEmployee(Employee employee) {
        this.employeeList.add(employee);
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Университет{" +
                "Адрес='" + address + '\'' +
                "{Список студентов=" + studentList +
                "}, {Список преподавателей=" + employeeList +
                "}}";
    }
}
