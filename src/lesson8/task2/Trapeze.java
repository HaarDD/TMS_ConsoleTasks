package lesson8.task2;

import base.DataUtil;

public class Trapeze extends Shape {

    private final double sideA;
    private final double sideB;
    private final double sideC;
    private final double sideD;

    {
        this.setShapeName("Трапеция");
    }

    public Trapeze(double sideA, double sideB, double sideC, double sideD) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
    }

    @Override
    double getSquare() {
        return DataUtil.unsafeRoundDouble(((sideA + sideB) / 2) *
                Math.sqrt(Math.pow(sideC, 2) - Math.pow((Math.pow(sideB - sideA, 2) + Math.pow(sideC, 2) - Math.pow(sideD, 2)) / (2 * (sideB - sideA)), 2)), 3);
    }

    @Override
    double getPerimeter() {
        return sideA + sideB + sideC + sideC;
    }

    @Override
    String getSidesInfo() {
        return "Сторона A: " + sideA + ", Сторона B: " + sideB + ", Сторона C: " + sideC + ", Сторона D: " + sideD;
    }
}
