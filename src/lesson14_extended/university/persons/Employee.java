package lesson14_extended.university.persons;

import java.util.Objects;

public class Employee extends Person {

    private String jobTitle;

    public Employee(String firstName, String lastName, String patronymic, String jobTitle) {
        super(firstName, lastName, patronymic);
        this.jobTitle = jobTitle;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(jobTitle, employee.jobTitle) && Objects.equals(getFirstName(), employee.getFirstName())
                && Objects.equals(getLastName(), employee.getLastName()) && Objects.equals(getPatronymic(), employee.getPatronymic());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), jobTitle, getFirstName(), getLastName(), getPatronymic());
    }

    @Override
    public String toString() {
        return "Работник " + super.toString() + ", должность: " + jobTitle;
    }
}
