package ExamPrep;

import java.util.Scanner;

public class ClearSkies3 {
    static int[] currentPosition = new int[2];
    static int armour = 300;
    static int enemies = 4;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dim = Integer.parseInt(scanner.nextLine());

        String[][] airSpace = new String[dim][dim];
        int newRow;
        int newCol;
        int currRow;
        int currCol;
        boolean success = false;

        for (int i = 0; i < dim; i++) {
            airSpace[i] = scanner.nextLine().split("");
            for (int j = 0; j < dim; j++) {
                if ("J".equals(airSpace[i][j])) {
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                }
            }
        }

        while (true) {
            String command = scanner.nextLine();
            System.out.println();
        }

    }
}
