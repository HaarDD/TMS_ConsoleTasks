package lesson4;

import base.ConsoleUtil;
import base.Runnable;
import base.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Дополненительное задание - написать любой алгоритм сортировки сложнее пузырька
Был выбрал алгоритм сортировки деревом
Использован материал: ru.wikipedia.org/wiki/Двоичное_дерево_поиска */
public class L4Task6Tree extends Runnable {

    public L4Task6Tree() {
        super("Сортировка деревом");
    }

    @Override
    public void run() {
        List<Double> list = new ArrayList<>();
        Tree tree = new Tree(1);
        tree.insert(new Tree(2));
        tree.insert(new Tree(-3));
        tree.insert(new Tree(5));
        tree.insert(new Tree(-15));
        tree.insert(new Tree(16));
        tree.traverseAscending(new Tree.AddToSortedList(list));
        ConsoleUtil.print("Проход с сортировкой: " + Arrays.toString(list.toArray()));
    }

}
