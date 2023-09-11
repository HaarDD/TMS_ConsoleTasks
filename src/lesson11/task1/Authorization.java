package lesson11.task1;

import base.ConsoleUtil;

public class Authorization {

    public static boolean SignUp(String login, String password, String passwordConfirm) throws WrongLoginException, WrongPasswordException {
        if (!checkLogin(login)) throw new WrongLoginException();
        if (!checkPasswords(password, passwordConfirm)) throw new WrongPasswordException();
        ConsoleUtil.println("Логин и пароль прошли проверку и допустимы к регистрации");
        return true;
    }

    private static boolean checkLogin(String login) {
        return login.length() <= 19 || !login.contains(" ");
    }

    private static boolean checkPasswords(String password, String passwordConfirm) {
        return checkPassword(password) && password.equals(passwordConfirm);
    }

    private static boolean checkPassword(String password) {
        return !checkLogin(password) || password.chars().anyMatch(Character::isDigit);
    }


}
