package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dim[0];
        int cols = dim[1];

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int maxSum = 0;
        int sum = 0;
        int rowIndex = 0;
        int colIndex = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row + 2 < rows && col + 2 < cols) {
                    sum += matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] + matrix[row + 1][col] +
                            matrix[row + 2][col] + matrix[row + 1][col + 1] + matrix[row + 1][col + 2] +
                            matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                }


                if (sum > maxSum) {
                    maxSum = sum;
                    sum = 0;
                    rowIndex = row;
                    colIndex = col;
                } else {
                    sum = 0;
                }
            }
        }

        System.out.println("Sum = " + maxSum);
        for (int row = rowIndex; row < rowIndex + 3; row++) {
            for (int col = colIndex; col < colIndex + 3; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }

    }
}
