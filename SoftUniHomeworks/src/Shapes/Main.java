package Shapes;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(2.0, 3.0);

        Circle circle = new Circle(3.0);

        System.out.println(rectangle.calculateArea());
        System.out.println(rectangle.calculatePerimeter());

        System.out.println(circle.calculateArea());
        System.out.println(circle.calculatePerimeter());
    }
}
