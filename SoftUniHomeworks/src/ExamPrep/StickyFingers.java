package ExamPrep;

import java.util.Scanner;

public class StickyFingers {
    static int sum = 0;
    static int[] coordinatesOfD = new int[2];
    static boolean jail = false;
    static int currRow;
    static int currCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dim = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");

        String[][] field = new String[dim][dim];

        int[] newPosition = new int[2];
        int[] currPosition;

        for (int i = 0; i < dim; i++) {
            field[i] = scanner.nextLine().split("\\s+");
        }

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                if ("D".equals(field[i][j])) {
                    coordinatesOfD[0] = i;
                    coordinatesOfD[1] = j;
                }
            }
        }
        currPosition = coordinatesOfD;

        for (String command : commands) {
            switch (command) {
                case "left":
                    currRow = currPosition[0];
                    currCol = currPosition[1];
                    newPosition[0] = currPosition[0];
                    newPosition[1] = currPosition[1] - 1;
                    if (validationOfIndex(newPosition, dim)) {
                        move(field, newPosition);
                        if (jail) {
                            break;
                        }
                        currPosition = newPosition;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currPosition[0] = currRow;
                        currPosition[1] = currCol;
                    }
                    break;
                case "right":
                    currRow = currPosition[0];
                    currCol = currPosition[1];
                    newPosition[0] = currPosition[0];
                    newPosition[1] = currPosition[1] + 1;
                    if (validationOfIndex(newPosition, dim)) {
                        move(field, newPosition);
                        if (jail) {
                            break;
                        }
                        currPosition = newPosition;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currPosition[0] = currRow;
                        currPosition[1] = currCol;
                    }
                    break;
                case "up":
                    currRow = currPosition[0];
                    currCol = currPosition[1];
                    newPosition[0] = currPosition[0] - 1;
                    newPosition[1] = currPosition[1];
                    if (validationOfIndex(newPosition, dim)) {
                        move(field, newPosition);
                        if (jail) {
                            break;
                        }
                        currPosition = newPosition;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currPosition[0] = currRow;
                        currPosition[1] = currCol;
                    }
                    break;
                case "down":
                    currRow = currPosition[0];
                    currCol = currPosition[1];
                    newPosition[0] = currPosition[0] + 1;
                    newPosition[1] = currPosition[1];
                    if (validationOfIndex(newPosition, dim)) {
                        move(field, newPosition);
                        if (jail) {
                            break;
                        }
                        currPosition = newPosition;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                        currPosition[0] = currRow;
                        currPosition[1] = currCol;
                    }
                    break;
            }
        }
        if (!jail) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", sum);
        }

        for (int i = 0; i < dim; i++) {
            for (int j = 0; j < dim; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean validationOfIndex(int[] newPosition, int dim) {
        return newPosition[0] >= 0 && newPosition[0] < dim &&
                newPosition[1] >= 0 && newPosition[1] < dim;
    }

    private static void move (String[][] field, int[] newPosition) {
        String symbol = field[newPosition[0]][newPosition[1]];
        switch (symbol) {
            case "+":
                field[newPosition[0]][newPosition[1]] = "D";
                field[currRow][currCol] = "+";
                break;
            case "$":
                field[newPosition[0]][newPosition[1]] = "D";
                field[currRow][currCol] = "+";
                int currSum = newPosition[0] * newPosition[1];
                sum += currSum;
                System.out.printf("You successfully stole %d$.%n", currSum);
                break;
            case "P":
                field[newPosition[0]][newPosition[1]] = "#";
                field[currRow][currCol] = "+";
                System.out.printf("You got caught with %d$, and you are going to jail.%n", sum);
                jail = true;
                break;
        }
    }
}
