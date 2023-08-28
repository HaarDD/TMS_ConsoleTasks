package lesson8.task1.positions;

import base.ConsoleUtil;
import lesson8.task1.JobPrintable;
import lesson8.task1.Person;

public class Director extends Person implements JobPrintable {

    private final String jobTitleDirector;

    public Director(String surname, String name, String patronymic, String jobTitle) {
        super(surname, name, patronymic);
        jobTitleDirector = jobTitle;
    }

    @Override
    public void printJob() {
        ConsoleUtil.println(super.toString() + " " + jobTitleDirector);
    }
}
