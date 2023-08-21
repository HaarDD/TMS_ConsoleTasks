package lesson6;

import base.ConsoleUtil;

/*Задача 1:
Создать класс CreditCard c полями номер счета, текущая сумма на счету. Добавьте
метод, который позволяет начислять сумму на кредитную карточку. Добавьте метод,
который позволяет снимать с карточки некоторую сумму. Добавьте метод, который
выводит текущую информацию о карточке. Напишите программу, которая создает три
объекта класса CreditCard у которых заданы номер счета и начальная сумма.
Тестовый сценарий для проверки: Положите деньги на первые две карточки и снимите с
третьей. Выведите на экран текущее состояние всех трех карточек.*/
public class CreditCard {

    private String ownerName;
    private Long cardNumber;
    private Long cardBalance;

    {
        ownerName = "INSTANT CARD";
        cardNumber = null;
    }

    public CreditCard(String ownerName, Long cardNumber) {
        this.ownerName = ownerName;
        this.cardNumber = cardNumber;
    }

    public CreditCard(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public CreditCard(String ownerName, Long cardNumber, Number cardBalance) {
        this(ownerName, cardNumber);
        this.cardBalance = cardBalance.longValue();
    }

    public CreditCard(Long cardNumber, Number cardBalance) {
        this(cardNumber);
        this.cardBalance = cardBalance.longValue();
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public Long getCardBalance() {
        return cardBalance;
    }

    public void putMoney(Number money) {
        this.cardBalance += money.longValue();
    }

    public void withdrawMoney(Number money) {
        long longMoney = money.longValue();
        if (this.cardBalance - longMoney > 0) this.cardBalance -= longMoney;
        else ConsoleUtil.println("Недостаточно денег для выполнения операции");
    }

    public void printCardInfo() {
        ConsoleUtil.println(this.toString());
    }

    public void printCardBalance() {
        ConsoleUtil.println(this.cardBalanceToString());
    }

    private String cardBalanceToString() {
        return "Остаток денег по карте: " + moneyToString();
    }

    private String moneyToString() {
        return this.cardBalance + " руб.";
    }

    @Override
    public String toString() {
        return "Кредитная карта\nНомер карты: " + this.cardNumber + "\nВладелец карты: " + this.ownerName + "\n" + cardBalanceToString();
    }
}
