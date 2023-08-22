package base;

import java.util.ArrayList;
import java.util.List;

public class TasksSwitcher {
    private final List<RunnableContainer> runnableContainers = new ArrayList<>();

    public void addLesson(RunnableContainer runnableContainer) {
        runnableContainers.add(runnableContainer);
    }

    public void printMenuList(MenuOption[] options) {
        ConsoleUtil.printLineDelimiter();
        for (int i = 0; i < options.length; i++) {
            ConsoleUtil.printOption(i + 1, options[i]);
        }

        ConsoleUtil.println("0. Выход");
        ConsoleUtil.printLineDelimiter();
    }

    public void runMenu(MenuOption[] options) {
        boolean isTasks = options instanceof Runnable[];
        printMenuList(options);
        int selectedNumber = (int) ConsoleUtil.getNumberInRange("Введите пункт меню: ", 0, Double.MAX_VALUE);

        if (selectedNumber == 0) {
            if (isTasks) {
                runTasksSwitcher();
            }
            return;
        }
        boolean optionWasFound = findOption(options, selectedNumber) != null;

        if (isTasks) {
            if (optionWasFound) {
                ((Runnable) findOption(options, selectedNumber)).run();
            } else {
                printWrongMenuOptionMessage();
            }
            runMenu(options);
        } else {
            if (optionWasFound) {
                runMenu(((RunnableContainer) findOption(options, selectedNumber)).getTasksList());
                return;
            } else {
                printWrongMenuOptionMessage();
            }
            runMenu(options);
        }
    }

    public void printWrongMenuOptionMessage() {
        ConsoleUtil.println("Такого пункта меню нет! Попробуйте еще раз");
    }

    public MenuOption findOption(MenuOption[] options, int position) {
        for (int i = 0; i < options.length; i++) {
            if (i == position - 1) {
                return options[i];
            }
        }
        return null;
    }

    public void runTasksSwitcher() {
        runMenu(runnableContainers.toArray(RunnableContainer[]::new));
    }

}
