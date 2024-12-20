package ExamPrep;

import java.util.Scanner;

public class Armory {
    static int[] currentPosition = new int[2];
    static int[] mirrorPosition1 = new int[2];
    static int[] mirrorPosition2 = new int[2];
    static int pricePaid;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dim = Integer.parseInt(scanner.nextLine());
        String[][] armory = new String[dim][dim];
        int newRow;
        int newCol;
        int currRow = 0;
        int currCol = 0;
        int m = 0;
        
        for (int i = 0; i < dim; i++) {
            armory[i] = scanner.nextLine().split("");
            for (int j = 0; j < dim; j++) {
                if ("A".equals(armory[i][j])) {
                    currentPosition[0] = i;
                    currentPosition[1] = j;
                }
                if ("M".equals(armory[i][j])) {
                    m++;
                    if (m == 1) {
                        mirrorPosition1[0] = i;
                        mirrorPosition1[1] = j;
                    } else {
                        mirrorPosition2[0] = i;
                        mirrorPosition2[1] = j;
                    }
                }
            }
        }

        int price = 0;

        while (pricePaid < 65) {
            String command = scanner.nextLine();

            if ("up".equals(command)) {
                newRow = currentPosition[0] - 1;
                newCol = currentPosition[1];
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                if (validationOfIndex(newRow, newCol, dim)) {
                    move(armory, newRow, newCol, currRow, currCol, price);
                } else {
                    System.out.println("I do not need more swords!");
                    break;
                }
            } else if ("down".equals(command)) {
                newRow = currentPosition[0] + 1;
                newCol = currentPosition[1];
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                if (validationOfIndex(newRow, newCol, dim)) {
                    move(armory, newRow, newCol, currRow, currCol, price);
                } else {
                    System.out.println("I do not need more swords!");
                    break;
                }
            } else if ("left".equals(command)) {
                newRow = currentPosition[0];
                newCol = currentPosition[1] - 1;
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                if (validationOfIndex(newRow, newCol, dim)) {
                    move(armory, newRow, newCol, currRow, currCol, price);
                } else {
                    System.out.println("I do not need more swords!");
                    break;
                }
            } else if ("right".equals(command)) {
                newRow = currentPosition[0];
                newCol = currentPosition[1] + 1;
                currRow = currentPosition[0];
                currCol = currentPosition[1];
                if (validationOfIndex(newRow, newCol, dim)) {
                    move(armory, newRow, newCol, currRow, currCol, price);
                } else {
                    System.out.println("I do not need more swords!");
                    break;
                }
            }
        }

        if (pricePaid >= 65) {
            System.out.println("Very nice swords, I will come back for more!");
        } else {
            armory[currRow][currCol] = "-";
        }

        System.out.printf("The king paid %d gold coins.%n", pricePaid);

        for (int i = 0; i < dim; i++) {
            System.out.println(String.join("", armory[i]));
        }
    }

    private static boolean validationOfIndex(int newRow, int newCol, int dim) {
        return newRow >= 0 && newRow < dim &&
                newCol >= 0 && newCol < dim;
    }

    private static void move(String[][] armory, int newRow, int newCol, int currRow, int currCol, int price) {
        String symbol = armory[newRow][newCol];

        if ("-".equals(symbol)) {
            armory[newRow][newCol] = "A";
            armory[currRow][currCol] = "-";
            currentPosition[0] = newRow;
            currentPosition[1] = newCol;

        } else if ("M".equals(symbol)) {
            if (newRow == mirrorPosition1[0] && newCol == mirrorPosition1[1]) {
                armory[currRow][currCol] = "-";
                armory[newRow][newCol] = "-";
                armory[mirrorPosition2[0]][mirrorPosition2[1]] = "-";
                currentPosition[0] = mirrorPosition2[0];
                currentPosition[1] = mirrorPosition2[1];
            } else {
                armory[currRow][currCol] = "-";
                armory[newRow][newCol] = "-";
                armory[mirrorPosition1[0]][mirrorPosition1[1]] = "-";
                currentPosition[0] = mirrorPosition1[0];
                currentPosition[1] = mirrorPosition1[1];
            }
        } else if (Character.isDigit(symbol.charAt(0))) {
            price = Integer.parseInt(symbol);
            pricePaid += price;
            armory[newRow][newCol] = "A";
            armory[currRow][currCol] = "-";
            currentPosition[0] = newRow;
            currentPosition[1] = newCol;
        }

    }
}
