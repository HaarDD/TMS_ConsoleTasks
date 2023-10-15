package lesson5;

import base.TaskRunnable;

import static base.ConsoleUtil.printIntMatrix;
import static base.ConsoleUtil.println;

/*Задача 3:
Найдите сумму элементов на главной диагонали:*/
public class L5Practice3 extends TaskRunnable {

    public L5Practice3() {
        super("Сумма на главной диагонали");
    }

    @Override
    public void runTask() {
        int[][] board = new int[5][5];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][i % 2 == 0 ? j : (board[i].length - 1 - j)] = (i * board[i].length) + j;
            }
        }
        printIntMatrix(board, 3);
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == j) sum += board[i][j];
            }
        }
        println("Сумма элементов главной диагонали: " + sum);
    }

}
