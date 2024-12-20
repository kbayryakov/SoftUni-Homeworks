package WorkingWithAbstraction;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            printRow(n, i);
        }

        for (int i = n - 1; i >= 1; i--) {
            printRow(n, i);
        }
    }

    private static void printRow(int n, int i) {
        for (int space = n - i; space > 0; space--) {
            System.out.print(" ");
        }
        for (int star = 1; star <= i; star++) {
            System.out.print("* ");
        }
        System.out.println();
    }
    
}