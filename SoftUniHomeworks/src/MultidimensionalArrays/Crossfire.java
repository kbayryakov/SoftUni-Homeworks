package MultidimensionalArrays;

import java.util.*;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        
        int rows = values[0];
        int cols = values[1];

        int n = 1;
        int[][] matrix = new int[rows][cols];
        int[][] newMatrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = n++;
            }
        }

        String command;
        while (!"Nuke it from orbit".equals(command = scanner.nextLine())) {
            int[] coordinates = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int row = coordinates[0];
            int col = coordinates[1];
            int radius = coordinates[2];
            newMatrix = matrix;

            for (int i = col - radius; i <= col + radius; i++) {
                if (i >= 0 && i < matrix.length) {
                    newMatrix[i] = removeElement(matrix[i], col);
                }
            }

            for (int i = row - radius; i <= row + radius; i++) {
                if (i >= 0 && i < matrix[row].length) {
                    newMatrix[row] = removeElement(matrix[row], i);
                }
            }
            System.out.println();
        }
    }
    public static int[] removeElement (int[] arr, int index) {
        int[] currArr = new int[arr.length - 1];
        if (index >= 0) System.arraycopy(arr, 0, currArr, 0, index);
        if (arr.length - (index + 1) >= 0)
            System.arraycopy(arr, index + 1, currArr, index, arr.length - (index + 1));
        return currArr;
    }
}
