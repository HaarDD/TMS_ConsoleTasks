package base;

public abstract class TaskBase extends MenuOption{
    public PrintUtil printUtil;

    public TaskBase(int number, String name) {
        super(number,name);
        this.printUtil = PrintUtil.getInstance();
    }

    public void runTask() {
    }
}
