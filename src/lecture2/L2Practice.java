package lecture2;

import base.PrintUtil;
import base.TaskBase;

public class L2Practice extends TaskBase {
    public L2Practice(PrintUtil printUtil) {
        super(printUtil, 1,"Практика. Вывод поры года по номеру, вывод чисел из while, вывод чисел из for по условиям");
    }

    @Override
    public void runTask() {
        printUtil.printOption(this);
        double monthNumber = Math.floor(printUtil.getNumberInRange("Введите номер месяца: ",1,12));
        printUtil.print(getMonthAndSeasonName(monthNumber));
    }

    private String getMonthAndSeasonName(double seasonNumber) {
        String result = "Месяц: ";
        result += switch ((int)seasonNumber) {
            case 1 -> "Январь";
            case 2 -> "Февраль";
            case 3 -> "Март";
            case 4 -> "Апрель";
            case 5 -> "Май";
            case 6 -> "Июнь";
            case 7 -> "Июль";
            case 8 -> "Август";
            case 9 -> "Сентябрь";
            case 10 -> "Октябрь";
            case 11 -> "Ноябрь";
            case 12 -> "Декабрь";
            default -> "Ошибка!";
        };
        result += " Пора года: ";
        result += switch ((int)Math.floor(seasonNumber/3)) {
            case 0,4 -> "Зима";
            case 1 -> "Весна";
            case 2 -> "Лето";
            case 3 -> "Осень";
            default -> "Ошибка!";
        };
        return result;
    }

}
