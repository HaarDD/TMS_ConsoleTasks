package lesson8.task2;

import base.DataUtil;

public class RegularPolygon extends Shape {
    private final double side;

    private final int numberOfSides;

    public RegularPolygon(double side, int numberOfSides) {
        this.side = side;
        this.numberOfSides = numberOfSides;
        this.setShapeName("Правильный " + numberOfSides + "-угольник");
    }

    @Override
    double getSquare() {
        return DataUtil.unsafeRoundDouble(((numberOfSides * Math.pow(side, 2)) / 4) * 1 / Math.tan(Math.toRadians(180d / numberOfSides)), 3);
    }

    @Override
    double getPerimeter() {
        return numberOfSides * side;
    }

    @Override
    String getSidesInfo() {
        return "Длина стороны: " + side;
    }
}
