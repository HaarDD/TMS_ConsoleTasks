package lesson7_live.university;

public class Teacher extends Employee {

    private String subject;

    public Teacher(String name, String surname, String subject) {
        super(name, surname);
        this.subject = subject;
    }

    public Teacher(String name, String surname) {
        super(name, surname);
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher{" + super.toString() +
                "subject='" + subject + '\'' +
                '}';
    }
}
