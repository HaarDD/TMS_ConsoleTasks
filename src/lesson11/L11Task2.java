package lesson11;

import base.ConsoleUtil;
import base.Runnable;


/**/
public class L11Task2 extends Runnable {

    public L11Task2() {
        super("Невыполнение finally");
    }

    @Override
    public void run() {
        int param = (int) ConsoleUtil.getNumberInRange("Введите, каким образом будет завершена программа:\n1 - бесконечный цикл\n2 - вызов System.exit\n", 1, 3);

        try {
            throw new Exception("Выброс исключения в блоке try для примера");
        } catch (Exception e) {
            ConsoleUtil.println(e);
            switch (param) {
                case 1 -> endlessCycle();
                case 2 -> systemExit();
            }
        } finally {
            ConsoleUtil.println("Блок finally");
        }

    }

    void endlessCycle() {
        while (true) {
            ConsoleUtil.print("Бесконечный цикл\t");
        }
    }

    void systemExit() {
        System.exit(1);
    }

}
