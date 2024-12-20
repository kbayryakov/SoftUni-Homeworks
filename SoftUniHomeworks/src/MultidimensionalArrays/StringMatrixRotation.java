package MultidimensionalArrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        String[] commandLine = command.split("\\(");
        String degreesValue = commandLine[1].replace(")", "");
        int degrees = Integer.parseInt(degreesValue);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input;
        int matrixCol = 0;
        while (!"END".equals(input = scanner.nextLine())) {
            if (input.length() > matrixCol) {
                matrixCol = input.length();
            }
            queue.offer(input);
        }

        char[][] matrix = new char[queue.size()][matrixCol];

        int row = 0;
        while (!queue.isEmpty()) {
            char[] queueElements = queue.poll().toCharArray();
            List<Character> elements = new ArrayList<>();
            for (int i = 0; i < queueElements.length; i++) {
                elements.add(queueElements[i]);
            }
            if (elements.size() < matrixCol) {
                int index = matrixCol - elements.size();
                for (int i = 1; i <= index; i++) {
                    elements.add(' ');
                }
            }
            char[] toMatrix = new char[elements.size()];
            for (int i = 0; i < elements.size(); i++) {
                toMatrix[i] = elements.get(i);
            }
            matrix[row] = toMatrix;
            row++;
        }

        while (degrees >= 360) {
            degrees -= 360;
        }

        if (degrees == 90) {
            for (int i = 0; i < matrix[0].length; i++) {
                for (int j = matrix.length - 1; j >= 0; j--) {
                    System.out.printf("%c", matrix[j][i]);
                }
                System.out.println();
            }
        } else if (degrees == 180) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                for (int j = matrix[0].length - 1; j >= 0; j--) {
                    System.out.printf("%c", matrix[i][j]);
                }
                System.out.println();
            }
        } else if (degrees == 270) {
            for (int i = matrix[0].length - 1; i >= 0; i--) {
                for (int j = 0; j < matrix.length; j++) {
                    System.out.printf("%c", matrix[j][i]);
                }
                System.out.println();
            }
        } else {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    System.out.printf("%c", matrix[i][j]);
                }
                System.out.println();
            }
        }

    }
}
