package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> periodicTable = new TreeSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] elements = scanner.nextLine().split("\\s+");

            periodicTable.addAll(Arrays.asList(elements));
        }

        for (String elements : periodicTable) {
            System.out.print(elements + " ");
        }
    }
}
