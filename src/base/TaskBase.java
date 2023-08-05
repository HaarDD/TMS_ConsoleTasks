package base;

public abstract class TaskBase extends MenuOption{
    public PrintUtil printUtil;

    public TaskBase(PrintUtil printUtil, int number, String name) {
        super(number,name);
        this.printUtil = printUtil;
    }

    public void runTask() {
    }
}
