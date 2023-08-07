package base;

import java.util.ArrayList;
import java.util.List;

public class TasksSwitcher {
    private final List<Lesson> lessons = new ArrayList<>();

    public void addLesson(Lesson lesson) {
        lessons.add(lesson);
    }

    public void printMenuList(MenuOption[] options) {
        PrintUtil.printLineDelimiter();
        for (MenuOption option : options) {
            PrintUtil.printOption(option);
        }
        PrintUtil.print("0. Выход");
        PrintUtil.printLineDelimiter();
    }

    public void runMenu(MenuOption[] options) {
        boolean isTasks = options instanceof TaskBase[];
        printMenuList(options);
        int selectedNumber = (int) PrintUtil.getNumberInRange("Введите пункт меню: ", 0, Double.MAX_VALUE);

        if (selectedNumber == 0) {
            if (isTasks) {
                runTasksSwitcher();
            }
            return;
        }
        boolean optionWasFound = findOption(options, selectedNumber) != null;

        if (isTasks) {
            if (optionWasFound) {
                ((TaskBase) findOption(options, selectedNumber)).runTask();
            } else {
                PrintUtil.print("Такого пункта меню нет! Попробуйте еще раз");
            }
            runMenu(options);
        } else {
            if (optionWasFound) {
                runMenu(((Lesson) findOption(options, selectedNumber)).getTasksList());
                return;
            } else {
                PrintUtil.print("Такого пункта меню нет! Попробуйте еще раз");
            }
            runMenu(options);
        }
    }

    public MenuOption findOption(MenuOption[] options, int position) {
        for (MenuOption option : options) {
            if (option.getNumber() == position) {
                return option;
            }
        }
        return null;
    }

    public void runTasksSwitcher() {
        runMenu(lessons.toArray(Lesson[]::new));
    }
}
