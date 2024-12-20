package WorkingWithAbstraction;

public class Rectangle {
    private Point bottomLeft;
    private Point topRight;

    public Rectangle(Point bottomLeft, Point topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Point getBottomLeft() {
        return bottomLeft;
    }

    public Point getTopRight() {
        return topRight;
    }

    public boolean contains(Point point) {
        return point.getCoordinateX() >= bottomLeft.getCoordinateX()
                && point.getCoordinateX() <= topRight.getCoordinateX()
                && point.getCoordinateY() >= bottomLeft.getCoordinateY()
                && point.getCoordinateY() <= topRight.getCoordinateY();
    }
}
