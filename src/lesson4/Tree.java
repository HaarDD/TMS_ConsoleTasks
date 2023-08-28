package lesson4;

import java.util.List;

public class Tree {
    double value;
    private Tree leftTree = null;
    private Tree rightTree = null;

    public Tree(double value) {
        this.value = value;
    }

    public void insert(Tree tree) {
        if (tree.value < value) {
            if (leftTree != null) {
                leftTree.insert(tree);
            } else leftTree = tree;
        } else {
            if (rightTree != null) {
                rightTree.insert(tree);
            } else rightTree = tree;
        }
    }

    public void traverseAscending(NodeAction action) {
        if (leftTree != null) {
            leftTree.traverseAscending(action);
        }
        action.act(this);
        if (rightTree != null) {
            rightTree.traverseAscending(action);
        }
    }

    //TODO удаление числа

    public interface NodeAction {
        void act(Tree tree);
    }

    public static class AddToSortedList implements NodeAction {
        List<Double> list;

        public AddToSortedList(List<Double> list) {
            this.list = list;
        }

        public void act(Tree tree) {
            list.add(tree.value);
        }
    }
}