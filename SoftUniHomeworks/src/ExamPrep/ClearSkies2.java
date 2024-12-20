package ExamPrep;

import java.util.Scanner;

public class ClearSkies2 {
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

        while (armour > 0) {
            String command = scanner.nextLine();

            if ("up".equals(command)) {
                newRow = currentPosition[0] - 1;
                newCol = currentPosition[1];
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                move(airSpace, newRow, newCol, currRow, currCol);
                if (enemies == 0) {
                    success = true;
                    break;
                }
            } else if ("down".equals(command)) {
                newRow = currentPosition[0] + 1;
                newCol = currentPosition[1];
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                move(airSpace, newRow, newCol, currRow, currCol);
                if (enemies == 0) {
                    success = true;
                    break;
                }
            } else if ("left".equals(command)) {
                newRow = currentPosition[0];
                newCol = currentPosition[1] - 1;
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                move(airSpace, newRow, newCol, currRow, currCol);
                if (enemies == 0) {
                    success = true;
                    break;
                }
            } else if ("right".equals(command)) {
                newRow = currentPosition[0];
                newCol = currentPosition[1] + 1;
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                move(airSpace, newRow, newCol, currRow, currCol);
                if (enemies == 0) {
                    success = true;
                    break;
                }
            }
        }

        if (success) {
            System.out.println("Mission accomplished, you neutralized the aerial threat!");
        } else {
            System.out.printf("Mission failed, your jetfighter was shot down! Last coordinates [%d, %d]!\n",
                    currentPosition[0], currentPosition[1]);
        }

        for (int i = 0; i < dim; i++) {
            System.out.println(String.join("", airSpace[i]));
        }
    }

    private static void move (String[][] airSpace, int newRow, int newCol, int currRow, int currCol) {
        String symbol = airSpace[newRow][newCol];

        if ("-".equals(symbol)) {
            airSpace[newRow][newCol] = "J";
            airSpace[currRow][currCol] = "-";
            currentPosition[0] = newRow;
            currentPosition[1] = newCol;
        } else if ("E".equals(symbol)) {
            airSpace[newRow][newCol] = "J";
            airSpace[currRow][currCol] = "-";
            currentPosition[0] = newRow;
            currentPosition[1] = newCol;
            if (enemies > 1) {
                armour -= 100;
                enemies--;
            }
        } else if ("R".equals(symbol)) {
            if (armour < 300) {
                armour = 300;
            }
            airSpace[newRow][newCol] = "-";
            airSpace[currRow][currCol] = "-";
            currentPosition[0] = newRow;
            currentPosition[1] = newCol;
        }
    }
}
