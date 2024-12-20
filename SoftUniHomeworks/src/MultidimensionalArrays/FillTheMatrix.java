package MultidimensionalArrays;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(",\\s+");

        int dim = Integer.parseInt(input[0]);
        String pattern = input[1];

        if (pattern.equals("A")) {
            printMatrix(patternA(dim));
        } else if (pattern.equals("B")) {
            printMatrix(patternB(dim));
        }
    }
    public static int[][] patternA (int dim) {
        int num = 1;
        int[][] matrix = new int[dim][dim];
        for (int col = 0; col < dim; col++) {
            for (int row = 0; row < dim; row++) {
                matrix[row][col] = num;
                num++;
            }
        }
        return matrix;
    }

    public static int[][] patternB (int dim) {
        int num = 1;
        int[][] matrix = new int[dim][dim];
        for (int col = 0; col < dim; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < dim; row++) {
                    matrix[row][col] = num;
                    num++;
                }
            } else {
                for (int row = dim - 1; row >= 0; row--) {
                    matrix[row][col] = num;
                    num++;
                }
            }
        }
        return matrix;
    }

    public static void printMatrix (int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
