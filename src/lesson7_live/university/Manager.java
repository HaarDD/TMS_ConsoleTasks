package lesson7_live.university;

public class Manager extends Employee {

    private String department;

    public Manager(String name, String surname, String department) {
        super(name, surname);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Менеджер{" + super.toString() +
                "Кафедра='" + department + '\'' +
                '}';
    }
}
