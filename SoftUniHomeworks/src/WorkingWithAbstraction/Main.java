package WorkingWithAbstraction;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pointsCoordinates = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Point bottomLeft = new Point(pointsCoordinates[0], pointsCoordinates[1]);
        Point topRight = new Point(pointsCoordinates[2], pointsCoordinates[3]);

        Rectangle rectangle = new Rectangle(bottomLeft, topRight);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            int[] points = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            Point point = new Point(points[0], points[1]);

            System.out.println(rectangle.contains(point));
        }

    }
}
