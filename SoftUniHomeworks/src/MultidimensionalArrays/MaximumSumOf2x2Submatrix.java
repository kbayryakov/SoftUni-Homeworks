package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];
        int[][] subMatrix = new int[2][2];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int sum = 0;
        int currSum = 0;
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                currSum = matrix[row][col] + matrix[row][col + 1] + matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (currSum > sum) {
                    sum = currSum;
                    subMatrix[0][0] = matrix[row][col];
                    subMatrix[0][1] = matrix[row][col + 1];
                    subMatrix[1][0] = matrix[row + 1][col];
                    subMatrix[1][1] = matrix[row + 1][col + 1];
                }
            }
        }

        for (int row = 0; row < subMatrix.length; row++) {
            for (int col = 0; col < subMatrix[row].length; col++) {
                System.out.print(subMatrix[row][col] + " ");
            }
            System.out.println();
        }

        System.out.println(sum);
    }
}
