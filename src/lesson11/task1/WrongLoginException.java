package lesson11.task1;

public class WrongLoginException extends Exception {

    public WrongLoginException() {
        super("Логин не подходит по требования!");
    }

    public WrongLoginException(String message) {
        super(message);
    }
}
