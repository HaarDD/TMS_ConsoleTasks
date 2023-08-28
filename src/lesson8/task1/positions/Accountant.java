package lesson8.task1.positions;

import base.ConsoleUtil;
import lesson8.task1.JobPrintable;
import lesson8.task1.Person;

public class Accountant extends Person implements JobPrintable {

    private final String jobTitleAccountant;

    public Accountant(String surname, String name, String patronymic, String jobTitle) {
        super(surname, name, patronymic);
        jobTitleAccountant = jobTitle;
    }

    @Override
    public void printJob() {
        ConsoleUtil.println(super.toString() + " " + jobTitleAccountant);
    }
}
