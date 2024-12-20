package ExamPrep;

import java.util.Scanner;

public class ClearSkies {
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
        boolean success = true;

        for (int i = 0; i < dim; i++) {
            airSpace[i] = scanner.nextLine().split("");
            for (int j = 0; j < dim; j++) {
                if ("J".equals(airSpace[i][j])) {
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                }
            }
        }


        String command = scanner.nextLine();
        while (enemies > 0) {
            if ("up".equalsIgnoreCase(command)) {
                newRow = currentPosition[0] - 1;
                newCol = currentPosition[1];
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                move(airSpace, newRow, newCol, currRow, currCol);
                if (armour == 0) {
                    success = false;
                    break;
                }

            } else if ("down".equalsIgnoreCase(command)) {
                newRow = currentPosition[0] + 1;
                newCol = currentPosition[1];
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                move(airSpace, newRow, newCol, currRow, currCol);
                if (armour == 0) {
                    success = false;
                    break;
                }
            } else if ("left".equalsIgnoreCase(command)) {
                newRow = currentPosition[0];
                newCol = currentPosition[1] - 1;
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                move(airSpace, newRow, newCol, currRow, currCol);
                if (armour == 0) {
                    success = false;
                    break;
                }
            } else if ("right".equalsIgnoreCase(command)) {
                newRow = currentPosition[0];
                newCol = currentPosition[1] + 1;
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                move(airSpace, newRow, newCol, currRow, currCol);
                if (armour == 0) {
                    success = false;
                    break;
                }
            }
            command = scanner.nextLine();
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
