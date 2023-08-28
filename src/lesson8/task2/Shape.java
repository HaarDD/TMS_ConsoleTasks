package lesson8.task2;

public abstract class Shape {

    private String shapeName;

    {
        shapeName = "Фигура";
    }

    void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    abstract double getSquare();

    abstract double getPerimeter();

    abstract String getSidesInfo();

    @Override
    public String toString() {
        return "Фигура: " + shapeName + "; Стороны: (" + getSidesInfo() + "); Периметр: " + getPerimeter() + "; Площадь: " + getSquare();
    }
}
