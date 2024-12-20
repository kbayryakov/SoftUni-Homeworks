package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimentions = readInputArray(scanner);

        int rows = dimentions[0];
        int cols = dimentions[1];

        int[][] matrix1 = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix1[row] = readInputArray(scanner);
        }

        dimentions = readInputArray(scanner);

        rows = dimentions[0];
        cols = dimentions[1];

        int[][] matrix2 = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix2[row] = readInputArray(scanner);
        }

        if (areEqual(matrix1, matrix2)) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    public static int[] readInputArray (Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    public static boolean areEqual (int[][] matrix1, int [][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }

        for (int row = 0; row < matrix1.length; row++) {
            if (matrix1[row].length != matrix2[row].length) {
                return false;
            }

            for (int col = 0; col < matrix1[row].length; col++) {
                if (matrix1[row][col] != matrix2[row][col]) {
                    return false;
                }
            }
        }

        return true;
    }
}
