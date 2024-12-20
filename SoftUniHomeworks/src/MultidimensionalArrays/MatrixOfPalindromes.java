package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dim[0];
        int cols = dim[1];
        StringBuilder element = new StringBuilder("aaa");

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.valueOf(element);
                char oldSymbol = element.charAt(1);
                char newSymbol = (char) (element.charAt(1) + 1);
                element.replace(1, 2, String.valueOf(newSymbol));
            }
            char symbol = (char) (element.charAt(0) + 1);
            element.delete(0, 3);
            element.append(symbol).append(symbol).append(symbol);
        }

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
