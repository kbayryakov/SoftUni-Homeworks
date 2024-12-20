package SetsAndMapsAdvanced;

import java.util.*;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int n = sizes[0];
        int m = sizes[1];

        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        Set<Integer> repeating = new LinkedHashSet<>();

        for (int i = 1; i <= n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            set1.add(num);
        }

        for (int i = 1; i <= m; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            set2.add(num);
        }

        for (int i = 0; i < n; i++) {
            int num1 = set1.iterator().next();
            set1.remove(num1);

            for (int j = 0; j < m; j++) {
                int num2 = set2.iterator().next();
                set2.remove(num2);

                if (num1 == num2) {
                    repeating.add(num1);
                }
                set2.add(num2);
            }
            set1.add(num1);
        }

        for (int num : repeating) {
            System.out.print(num + " ");
        }
    }
}
