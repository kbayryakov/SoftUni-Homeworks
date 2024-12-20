package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int[][] newMatrix = new int[matrix.length][matrix[0].length];

        int[] wrongElementCoordinates =  Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int wrongElement = matrix[wrongElementCoordinates[0]][wrongElementCoordinates[1]];
        int newElement = 0;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongElement) {
                    if (row - 1 >= 0 && matrix[row - 1][col] != wrongElement) {
                        newElement += matrix[row - 1][col];
                    }
                    if (row + 1 < rows && matrix[row + 1][col] != wrongElement) {
                        newElement += matrix[row + 1][col];
                    }
                    if (col - 1 >= 0 && matrix[row][col - 1] != wrongElement) {
                        newElement += matrix[row][col - 1];
                    }
                    if (col + 1 < matrix[row].length && matrix[row][col + 1] != wrongElement) {
                        newElement += matrix[row][col + 1];
                    }
                    newMatrix[row][col] = newElement;
                    newElement = 0;
                } else {
                    newMatrix[row][col] = matrix[row][col];
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < newMatrix[row].length; col++) {
                System.out.print(newMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

