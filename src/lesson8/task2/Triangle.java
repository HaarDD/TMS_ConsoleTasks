package lesson8.task2;

import base.DataUtil;

public class Triangle extends Shape {


    private final double sideA;
    private final double sideB;
    private final double sideC;

    {
        this.setShapeName("Треугольник");
    }

    public Triangle(double sideA, double sideB, double sideC) throws IllegalArgumentException {
        if (!isTriangle(sideA, sideB, sideC)) {
            throw new IllegalArgumentException("Треугольник неправильный!");
        }
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    static boolean isTriangle(double sideOne, double sideTwo, double sideThree) {
        return (!(sideOne >= sideTwo + sideThree)) && (!(sideTwo >= sideOne + sideThree)) && (!(sideThree >= sideOne + sideTwo));
    }

    @Override
    double getSquare() {
        double semiPerimeter = getPerimeter() / 2;
        return DataUtil.unsafeRoundDouble(Math.sqrt(semiPerimeter * (semiPerimeter - sideA) * (semiPerimeter - sideB) * (semiPerimeter - sideC)), 3);
    }

    @Override
    double getPerimeter() {
        return DataUtil.unsafeRoundDouble(sideA + sideB + sideC, 3);
    }

    @Override
    String getSidesInfo() {
        return "Сторона A: " + sideA + ", Сторона B: " + sideB + ", Сторона C: " + sideC;
    }
}
