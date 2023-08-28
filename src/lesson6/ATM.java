package lesson6;

import base.ConsoleUtil;

import java.util.*;

/*Задача *:
Создать класс, описывающий банкомат. Набор купюр, находящихся в банкомате, должен
задаваться тремя свойствами: количеством купюр номиналом 20, 50 и 100. Сделать
метод для добавления денег в банкомат. Сделать функцию, снимающую деньги, которая
принимает сумму денег, а возвращает булевое значение - успешность выполнения
операции. При снятии денег, функция должна распечатывать каким количеством купюр
какого номинала выдаётся сумма. Создать конструктор с тремя параметрами -
количеством купюр каждого номинала.*/

public class ATM {

    private final List<Integer> banknotesSet;

    private int banknotesTotalSum;

    {
        this.banknotesSet = new ArrayList<>();
    }

    public ATM(Banknote... banknotes) {
        addBanknotes(banknotes);
    }

    private void addBanknotes(Banknote... banknotes) {
        for (Banknote banknote : banknotes) {
            for (int i = 0; i < banknote.count; i++) {
                this.banknotesSet.add(banknote.getBanknote());
            }
        }
        sortBanknotesSet();
        countBanknotesTotalSum();
    }


    private void sortBanknotesSet() {
        this.banknotesSet.sort(Comparator.comparingInt(banknote -> -(int) banknote));
    }

    private void countBanknotesTotalSum() {
        this.banknotesTotalSum = 0;
        this.banknotesSet.forEach(banknote -> banknotesTotalSum += banknote);
    }


    private List<Banknote> banknotesSetToBanknotesList(List<Integer> banknotesSet) {
        if (banknotesSet.size() == 0) {
            return null;
        }

        List<Banknote> banknotesList = new ArrayList<>();
        banknotesList.add(new Banknote(banknotesSet.get(0), 1));

        for (int i = 1; i < banknotesSet.size(); i++) {
            Banknote lastBanknote = banknotesList.get(banknotesList.size() - 1);
            Integer currentBanknote = banknotesSet.get(i);

            if (lastBanknote.getBanknote() == currentBanknote) {
                lastBanknote.count++;
            } else {
                banknotesList.add(new Banknote(currentBanknote, 1));
            }
        }
        return banknotesList;
    }

    private void printAvailableBanknotes() {
        printAvailableBanknotes(banknotesSetToBanknotesList(banknotesSet), "Купюры в банкомате: ");
    }

    private void printBanknotesSet(List<Integer> banknotes, String comment) {
        printAvailableBanknotes(banknotesSetToBanknotesList(banknotes), comment);
    }

    private void printAvailableBanknotes(List<Banknote> banknotes, String comment) {
        ConsoleUtil.printLineDelimiter();
        ConsoleUtil.println(comment);
        if (isBanknotesCountInvalid()) return;
        for (Banknote banknote : banknotes) {
            ConsoleUtil.print(banknote + " ");
        }
        ConsoleUtil.println();
    }

    private void withdrawBanknotes(List<Integer> banknotes) {
        printBanknotesSet(banknotes, "Купюры к выдаче");
        banknotes.forEach(banknotesSet::remove);
        countBanknotesTotalSum();
        printAvailableBanknotes();
    }

    private boolean isBanknotesCountInvalid() {
        if (banknotesSet.size() != 0) {
            return false;
        } else {
            ConsoleUtil.println("Купюр нет!");
            return true;
        }
    }

    private void giveMoneyGreedilyMethod() {
        if (isBanknotesCountInvalid()) return;
        int money = getMoneyToWithdraw();
        List<Integer> banknotesSetToIssue = new ArrayList<>();
        int moneyRest = money;

        for (int i = 0; i < banknotesSet.size(); i++) {
            Integer integer = banknotesSet.get(i);
            if (integer > moneyRest) continue;
            moneyRest -= integer;
            banknotesSetToIssue.add(integer);
            if (moneyRest == 0) {
                withdrawBanknotes(banknotesSetToIssue);
                return;
            }
        }
        printNotEnoughBanknotes(money);

    }


    private void giveMoneyDynamicMethod() {
        if (isBanknotesCountInvalid()) return;
        int money = getMoneyToWithdraw();

        Map<Integer, List<Integer>> sumAndBanknotesSet = new HashMap<>();
        sumAndBanknotesSet.put(0, null);

        for (int i = 0; i < banknotesSet.size(); i++) {
            int banknote = banknotesSet.get(i);
            Map<Integer, List<Integer>> newSumAndBanknotesSet = new HashMap<>();

            sumAndBanknotesSet.forEach((sum, banknotesSet) -> {
                int newSum = sum + banknote;
                List<Integer> tempList = new ArrayList<>();
                if (banknotesSet != null) {
                    tempList.addAll(banknotesSet);
                }
                tempList.add(banknote);
                newSumAndBanknotesSet.put(newSum, tempList);
            });
            Map<Integer, List<Integer>> tempSumAndBanknotesSet = new HashMap<>();
            tempSumAndBanknotesSet.putAll(newSumAndBanknotesSet);
            tempSumAndBanknotesSet.putAll(sumAndBanknotesSet);
            sumAndBanknotesSet = tempSumAndBanknotesSet;
        }

        if (sumAndBanknotesSet.get(money) == null) {
            printNotEnoughBanknotes(money);
        } else {
            withdrawBanknotes(sumAndBanknotesSet.get(money));
        }
    }

    private int getMoneyToWithdraw() {
        int minimum = banknotesSet.get(banknotesSet.size() - 1);
        int maximum = banknotesTotalSum;
        return (int) ConsoleUtil.getNumberInRange("Введите сумму от " + minimum + " до " + maximum + ": ", minimum, maximum);
    }

    private void addBanknoteFromConsole() {
        addBanknotes(new Banknote((int) ConsoleUtil.getNumberInRange("Введите банкноту: ", 1), (int) ConsoleUtil.getNumberInRange("Введите количество: ", 1)));
    }

    private void printNotEnoughBanknotes(int money) {
        ConsoleUtil.println("Банкомат не обладает нужным количеством купюр для снятия " + money + " руб.");
    }

    public void runATM() {
        final int GIVE_MONEY_GREEDILY = 1;
        final int GIVE_MONEY_DYNAMIC = 2;
        final int ADD_BANKNOTE = 3;
        final int CHECK_BANKNOTES_SET = 4;
        final int CLEAR_BANKNOTES_SET = 5;
        final int EXIT_ATM = 0;

        int selected = -1;
        while (selected != EXIT_ATM) {
            ConsoleUtil.printLineDelimiter();
            ConsoleUtil.println(GIVE_MONEY_GREEDILY + ". Снятие денег жадным методом");
            ConsoleUtil.println(GIVE_MONEY_DYNAMIC + ". Снятие денег динамическим методом");
            ConsoleUtil.println(ADD_BANKNOTE + ". Добавить купюру в банкомат");
            ConsoleUtil.println(CHECK_BANKNOTES_SET + ". Отобразить доступные купюры");
            ConsoleUtil.println(CLEAR_BANKNOTES_SET + ". Очистить банкомат от купюр");
            ConsoleUtil.println(EXIT_ATM + ". Выход");
            selected = (int) ConsoleUtil.getNumberInRange("Выберите пункт: ", EXIT_ATM, CLEAR_BANKNOTES_SET);
            switch (selected) {
                case GIVE_MONEY_GREEDILY -> giveMoneyGreedilyMethod();
                case GIVE_MONEY_DYNAMIC -> giveMoneyDynamicMethod();
                case ADD_BANKNOTE -> addBanknoteFromConsole();
                case CHECK_BANKNOTES_SET -> printAvailableBanknotes();
                case CLEAR_BANKNOTES_SET -> banknotesSet.clear();
                case EXIT_ATM -> ConsoleUtil.println("Выход...");
                default -> ConsoleUtil.println("Банкомат не имеет функции по номером " + selected);
            }
        }

    }


}
