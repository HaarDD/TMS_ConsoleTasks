package lesson11.task1;

public class WrongPasswordException extends Exception {

    public WrongPasswordException() {
        super("Пароль не подходит по требования!");
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}
