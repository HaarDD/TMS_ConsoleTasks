package base;

public class Lesson extends MenuOption {
    final private TaskBase[] tasksList;

    public Lesson(int number, String name, TaskBase[] tasksList) {
        super(number, name);
        this.tasksList = tasksList;
    }

    public TaskBase[] getTasksList() {
        return tasksList;
    }
}
