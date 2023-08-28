package lesson8.task2;

import base.DataUtil;

public class Circle extends Shape {

    private final double r;

    {
        this.setShapeName("Круг");
    }

    public Circle(double r) {
        this.r = r;
    }

    @Override
    double getSquare() {
        return DataUtil.unsafeRoundDouble(Math.PI * r * r, 3);
    }

    @Override
    double getPerimeter() {
        return DataUtil.unsafeRoundDouble(2 * Math.PI * r, 3);
    }

    @Override
    String getSidesInfo() {
        return "Радиус: " + r;
    }
}
