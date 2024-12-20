package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int row = 0; row < n; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int diagonal1 = 0;
        for (int i = 0; i < n; i++) {
            diagonal1 += matrix[i][i];
        }

        int diagonal2 = 0;
        int col = n -1;
        for (int i = 0; i < n; i++) {
            diagonal2 += matrix[i][col];
            col--;
        }

        System.out.println(Math.abs(diagonal1 - diagonal2));
    }
}
