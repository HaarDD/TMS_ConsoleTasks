package lesson20;

import base.ConsoleUtil;
import base.TaskRunnable;
import lesson20.task1.entities.User;
import lesson20.task1.entities.UserDao;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Optional;
import java.util.stream.Collectors;


/*Задача
CRUD таблицы User*/
public class L20Task1 extends TaskRunnable {

    private static final String CONNECTION_JSON_FILE = "src/lesson20/task1/connection/connection.json";
    private UserDao userDao;

    public L20Task1() {
        super("CRUD");
    }

    @Override
    public void runTask() {
        Connection connection = connectDatabase(CONNECTION_JSON_FILE);
        userDao = new UserDao(connection);

        final int SHOW_ALL_USERS = 1;
        final int CREATE_USER = 2;
        final int FIND_USER_BY_ID = 3;
        final int UPDATE_USER = 4;
        final int REMOVE_USER = 5;
        final int EXIT_MENU = 0;

        int selected = -1;
        while (selected != EXIT_MENU) {
            ConsoleUtil.printLineDelimiter();
            ConsoleUtil.println(SHOW_ALL_USERS + ". Отобразить всех пользователей\n"
                    + CREATE_USER + ". Добавить пользователя\n"
                    + FIND_USER_BY_ID + ". Найти пользователя по id\n"
                    + UPDATE_USER + ". Изменить пользователя\n"
                    + REMOVE_USER + ". Удалить пользователя\n"
                    + EXIT_MENU + ". Выход");
            selected = (int) ConsoleUtil.getNumberInRange("Выберите пункт: ", EXIT_MENU, REMOVE_USER);
            switch (selected) {
                case SHOW_ALL_USERS -> printAllUsers();
                case CREATE_USER -> createUser();
                case FIND_USER_BY_ID -> printUserById();
                case UPDATE_USER -> updateUser();
                case REMOVE_USER -> removeUser();
                case EXIT_MENU -> ConsoleUtil.println("Выход...");
                default -> ConsoleUtil.println("Функции под таким номером нет (" + selected + ')');
            }
        }
    }

    private Connection connectDatabase(String connectionJson) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(connectionJson));
            JSONObject connection = (JSONObject) jsonObject.get("lesson_20_connection");
            return DriverManager.getConnection((String) connection.get("url"), (String) connection.get("login"), (String) connection.get("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void printAllUsers() {
        ConsoleUtil.println(userDao.getAll().stream().map(User::toString).collect(Collectors.joining("\n")));
    }

    public void printUserById() {
        Optional<User> user = userDao.get((long) ConsoleUtil.getNumberInRange("Введите id: ", 0));
        if (user.isPresent()) {
            ConsoleUtil.println(user.get());
        } else {
            ConsoleUtil.println("Пользователь не найден!");
        }
    }

    public void createUser() {
        User user = new User(ConsoleUtil.getString("Введите имя: "),
                ConsoleUtil.getString("Введите фамилию: "),
                ConsoleUtil.getString("Введите отчество: "));
        userDao.save(user);
    }

    public void removeUser() {
        Optional<User> user = userDao.get((long) ConsoleUtil.getNumberInRange("Введите id: ", 0));
        if (user.isPresent()) {
            userDao.delete(user.get());
            ConsoleUtil.println("Пользователь удален!");
        } else {
            ConsoleUtil.println("Пользователь не найден!");
        }
    }

    public void updateUser() {
        Optional<User> user = userDao.get((long) ConsoleUtil.getNumberInRange("Введите id: ", 0));
        if (user.isPresent()) {
            userDao.update(user.get(), ConsoleUtil.getString("Введите имя: "),
                    ConsoleUtil.getString("Введите фамилию: "),
                    ConsoleUtil.getString("Введите отчество: "));
            ConsoleUtil.println("Пользователь изменен!");
        } else {
            ConsoleUtil.println("Пользователь не найден!");
        }
    }

}
