package base;

public class Lecture extends MenuOption {
    final private TaskBase[] tasksList;

    public Lecture(int number, String name, TaskBase[] tasksList) {
        super(number, name);
        this.tasksList = tasksList;
    }

    public TaskBase[] getTasksList() {
        return tasksList;
    }
}
