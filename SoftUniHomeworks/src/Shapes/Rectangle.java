package Shapes;

public class Rectangle extends Shape {
    private Double height;
    private Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    protected Double calculatePerimeter() {
        return 2 * this.height + 2 * this.width;
    }

    @Override
    protected Double calculateArea() {
        return this.width * this.height;
    }
}
