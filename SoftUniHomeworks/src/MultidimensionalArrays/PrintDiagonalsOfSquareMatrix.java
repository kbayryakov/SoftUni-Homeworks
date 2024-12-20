package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dim = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[dim][dim];

        for (int row = 0; row < dim; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        int counter = 0;
        int row = 0;
        int col = 0;

        while (counter < dim) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
            counter++;
        }
        System.out.println();

        row = dim - 1;
        col = 0;
        counter = 0;

        while (counter < dim) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
            counter++;
        }
    }
}
