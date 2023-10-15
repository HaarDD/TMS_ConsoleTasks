package lesson8;

import base.ConsoleUtil;
import base.TaskRunnable;
import lesson8.task2.*;

/*Задача 2:
Написать иерархию классов Фигура, Треугольник, Прямоугольник, Круг. Реализовать
функцию подсчета площади для каждого типа фигуры и подсчет периметра(используя
абстрактный класс/методы). Создать массив из 5 разных фигур. Вывести на экран сумму
периметра всех фигур в массиве.*/
public class L8Task2 extends TaskRunnable {

    public L8Task2() {
        super("Иерархия классов \"Фигура\", \"Треугольник\", \"Прямоугольник\", \"Круг\", \"Трапеция\"");
    }

    @Override
    public void runTask() {
        Shape[] shapes = new Shape[]{
                new Triangle(1, 2, 2),
                new Rectangle(3, 5),
                new Circle(5),
                new Trapeze(2, 4, 3, 2),
                new RegularPolygon(5, 6)};

        for (Shape shape : shapes) ConsoleUtil.println(shape);
    }

}
