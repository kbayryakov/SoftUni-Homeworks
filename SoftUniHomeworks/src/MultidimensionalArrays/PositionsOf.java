package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] dimentions = readInputArray(scanner);
        int rows = dimentions[0];
        int cols = dimentions[1];
        boolean isFound = false;

        int [][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = readInputArray(scanner);
        }

        int number = Integer.parseInt(scanner.nextLine());

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == number) {
                    System.out.printf("%d %d\n", row, col);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }

    }

    public static int[] readInputArray (Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
