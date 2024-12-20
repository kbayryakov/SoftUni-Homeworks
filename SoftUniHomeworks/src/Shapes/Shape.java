package Shapes;

public abstract class Shape {
    private Double perimeter;
    private Double area;

    protected abstract Double calculatePerimeter();
    protected abstract Double calculateArea();
}
