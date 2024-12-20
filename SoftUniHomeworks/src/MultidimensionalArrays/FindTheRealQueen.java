package MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] matrix = new char[8][8];
        boolean isRealQueen = false;

        for (int row = 0; row < 8; row++) {
            matrix[row] = scanner.nextLine().replaceAll("\\s+", "").toCharArray();
        }

        int queenCounter = 0;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (matrix[row][col] == 'q') {
                    for (int i = 0; i < matrix[row].length; i++) {
                        if (matrix[row][i] == 'q') {
                            queenCounter++;
                            if (queenCounter <= 1) {
                                isRealQueen = true;
                            } else {
                                isRealQueen = false;
                                queenCounter = 0;
                                break;
                            }
                        }
                    }
                    if (isRealQueen) {
                        queenCounter = 0;
                        for (int i = 0; i < matrix[col].length; i++) {
                            if (matrix[i][col] == 'q') {
                                queenCounter++;
                                if (queenCounter > 1) {
                                    isRealQueen = false;
                                    queenCounter = 0;
                                    break;
                                }
                            }
                        }
                    }
                    if (isRealQueen) {
                        queenCounter = 0;
                        int a = row;
                        int b = col;
                        while (a >= 0 && b >= 0) {
                            if (matrix[a][b] == 'q')
                                queenCounter++;
                            if (queenCounter > 1) {
                                isRealQueen = false;
                                queenCounter = 0;
                                break;
                            }
                            a--;
                            b--;
                        }
                    }
                    if (isRealQueen) {
                        queenCounter = 0;
                        int a = row;
                        int b = col;
                        while (a >= 0 && b <= 7) {
                            if (matrix[a][b] == 'q')
                                queenCounter++;
                            if (queenCounter > 1) {
                                isRealQueen = false;
                                queenCounter = 0;
                                break;
                            }
                            a--;
                            b++;
                        }
                    }
                    if (isRealQueen) {
                        queenCounter = 0;
                        int a = row;
                        int b = col;
                        while (a <= 7 && b >= 0) {
                            if (matrix[a][b] == 'q')
                                queenCounter++;
                            if (queenCounter > 1) {
                                isRealQueen = false;
                                queenCounter = 0;
                                break;
                            }
                            a++;
                            b--;
                        }
                    }
                    if (isRealQueen) {
                        queenCounter = 0;
                        int a = row;
                        int b = col;
                        while (a <= 7 && b <= 7) {
                            if (matrix[a][b] == 'q')
                                queenCounter++;
                            if (queenCounter > 1) {
                                isRealQueen = false;
                                queenCounter = 0;
                                break;
                            }
                            a++;
                            b++;
                        }
                    }
                }
                if (isRealQueen) {
                    queenCounter = 0;
                    System.out.print(row + " " + col);
                    isRealQueen = false;
                }
            }
        }
    }
}