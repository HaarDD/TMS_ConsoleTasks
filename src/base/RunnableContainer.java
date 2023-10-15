package base;

public class RunnableContainer extends MenuOption {
    final private TaskRunnable[] tasksList;

    public RunnableContainer(String name, TaskRunnable[] tasksList) {
        super(name);
        this.tasksList = tasksList;
    }

    public TaskRunnable[] getTasksList() {
        return tasksList;
    }
}
