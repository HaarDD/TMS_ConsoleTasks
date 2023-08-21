package lesson5;

import base.ConsoleUtil;
import base.Runnable;

/*Задача 2:
Создать программу для раскраски шахматной доски с помощью цикла. Создать
двумерный массив String 8х8. С помощью циклов задать элементам массива значения
B(Black) или W(White). При выводе результат работы программы должен быть
следующим:
W B W B W B W B
B W B W B W B W
W B W B W B W B
B W B W B W B W
W B W B W B W B
B W B W B W B W
W B W B W B W B
B W B W B W B W*/
public class L5Task2 extends Runnable {

    public L5Task2() {
        super("Шахматная доска");
    }


    @Override
    public void run() {
        String[][] board = new String[8][8];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = (i + j) % 2 == 0 ? "W" : "B";
            }
        }
        ConsoleUtil.printStringMatrix(board, 1);
    }
}
