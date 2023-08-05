package base;

import java.util.ArrayList;
import java.util.List;

public class TasksSwitcher {
    final private static PrintUtil printUtil = new PrintUtil();
    private final List<Lecture> lectures = new ArrayList<>();

    public void addLecture(Lecture lecture){
        lectures.add(lecture);
    }
    public void printMenuList(MenuOption[] options){
        printUtil.printLineDelimiter();
        for (MenuOption option : options) {
            printUtil.printOption(option);
        }
        printUtil.print("0. Выход");
        printUtil.printLineDelimiter();
    }

    public void runMenu(MenuOption[] options){
        boolean isTasks = options instanceof TaskBase[];
        printMenuList(options);
        int selectedNumber = (int)printUtil.getNumber("Введите пункт меню: ",false);

        if(selectedNumber==0){
            if(isTasks){
                runTasksSwitcher();
            } else {
                return;
            }
            return;
        }
        boolean optionWasFound = findOption(options,selectedNumber) != null;

        if(isTasks){
            if(optionWasFound){
                ((TaskBase)findOption(options,selectedNumber)).runTask();
            }else{
                printUtil.print("Такого пункта меню нет! Попробуйте еще раз");
            }
            runMenu(options);
        } else{
            if(!optionWasFound){
                printUtil.print("Такого пункта меню нет! Попробуйте еще раз");
            }
            runMenu(((Lecture) findOption(options,selectedNumber)).getTasksList());
        }
    }
    public MenuOption findOption(MenuOption[] options, int position){
        for (MenuOption option : options) {
            if(option.getNumber()==position){
                return option;
            }
        }
        return null;
    }
    public void runTasksSwitcher(){
        runMenu(lectures.toArray(Lecture[]::new));
    }
}
