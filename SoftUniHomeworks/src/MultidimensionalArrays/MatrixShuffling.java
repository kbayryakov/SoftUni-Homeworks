package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dim = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dim[0];
        int cols = dim[1];

        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split("\\s+");
        }

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] commands = input.split("\\s+");
            String command = commands[0];

            if (command.equals("swap")) {
                if (commands.length == 5) {
                    int row1 = Integer.parseInt(commands[1]);
                    int col1 = Integer.parseInt(commands[2]);
                    int row2 = Integer.parseInt(commands[3]);
                    int col2 = Integer.parseInt(commands[4]);

                    if (row1 >= 0 && row1 < rows && row2 >= 0 && row2 < rows &&
                            col1 >=0 && col1 < cols && col2 >=0 && col2 < cols) {
                        String element1 = matrix[row1][col1];
                        String element2 = matrix[row2][col2];
                        matrix[row1][col1] = element2;
                        matrix[row2][col2] = element1;

                        for (int row = 0; row < rows; row++) {
                            for (int col = 0; col < cols; col++) {
                                System.out.print(matrix[row][col] + " ");
                            }
                            System.out.println();
                        }
                    } else {
                        System.out.println("Invalid input!");
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        }
    }
}
