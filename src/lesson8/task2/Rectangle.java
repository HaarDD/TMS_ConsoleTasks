package lesson8.task2;

public class Rectangle extends Shape {

    private final double width;
    private final double length;

    {
        this.setShapeName("Прямоугольник");
    }

    public Rectangle(double valueOne, double valueTwo) {
        //т.к. длина - большая сторона прямоугольника
        if (valueOne > valueTwo) {
            this.width = valueTwo;
            this.length = valueOne;
        } else {
            this.width = valueOne;
            this.length = valueTwo;
        }
    }

    @Override
    double getSquare() {
        return width * length;
    }

    @Override
    double getPerimeter() {
        return (width + length) * 2;
    }

    @Override
    String getSidesInfo() {
        return "Длина: " + length + ", Ширина: " + width;
    }
}
