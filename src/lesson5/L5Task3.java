package lesson5;

import base.ConsoleUtil;
import base.Runnable;

/*Задача *:
Даны числа n и m. Создайте массив A[n][m] и заполните его змейкой (см. пример).
Формат входных данных:
Программа получает на вход два числа n и m.
Формат выходных данных:
Программа должна вывести полученный массив, отводя на вывод каждого числа ровно 3
символа.*/
public class L5Task3 extends Runnable {

    public L5Task3() {
        super("Заполнение змейкой");
    }

    @Override
    public void run() {
        int[][] board = new int[(int) ConsoleUtil.getNumberInRange("Введите кол-во строк: ", 2, 100)]
                [(int) ConsoleUtil.getNumberInRange("Введите кол-во столбцов: ", 2, 100)];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][i % 2 == 0 ? j : (board[i].length - 1 - j)] = (i * board[i].length) + j;
            }
        }
        ConsoleUtil.printIntMatrix(board, 3);
    }
}
