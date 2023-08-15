package base;

public class RunnableContainer extends MenuOption {
    final private Runnable[] tasksList;

    public RunnableContainer(String name, Runnable[] tasksList) {
        super(name);
        this.tasksList = tasksList;
    }

    public Runnable[] getTasksList() {
        return tasksList;
    }
}
