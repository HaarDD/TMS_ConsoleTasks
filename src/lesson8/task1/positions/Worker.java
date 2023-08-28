package lesson8.task1.positions;

import base.ConsoleUtil;
import lesson8.task1.JobPrintable;
import lesson8.task1.Person;

public class Worker extends Person implements JobPrintable {

    private final String jobTitleWorker;

    public Worker(String surname, String name, String patronymic, String jobTitle) {
        super(surname, name, patronymic);
        jobTitleWorker = jobTitle;
    }

    @Override
    public void printJob() {
        ConsoleUtil.println(super.toString() + " " + jobTitleWorker);
    }
}
