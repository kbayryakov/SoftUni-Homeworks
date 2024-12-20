package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix1 = new char[rows][cols];
        char[][] matrix2 = new char[rows][cols];
        char[][] matrix3 = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String input = scanner.nextLine();
            char[] symbols = input.replaceAll("\\s+", "").toCharArray();
            matrix1[row] = symbols;
        }

        for (int row = 0; row < rows; row++) {
            String input = scanner.nextLine();
            char[] symbols = input.replaceAll("\\s+", "").toCharArray();
            matrix2[row] = symbols;
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix1[row][col] == matrix2[row][col]) {
                    matrix3[row][col] = matrix1[row][col];
                } else {
                    matrix3[row][col] = '*';
                }
            }
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix3[row][col] + " ");
            }
            System.out.println();
        }

    }
}
