package SetsAndMapsAdvanced;

import java.util.*;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<Integer> firstPlayer = new LinkedHashSet<>();
        Set<Integer> secondPlayer = new LinkedHashSet<>();
        boolean isEmpty = false;

        for (int i = 0; i <= 1; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            if (i % 2 == 0) {
                for (int num : input) {
                    firstPlayer.add(num);
                }
            } else {
                for (int num : input) {
                    secondPlayer.add(num);
                }
            }
        }

        for (int i = 1; i <= 50; i++) {
            int firstNum = firstPlayer.iterator().next();
            firstPlayer.remove(firstNum);
            int secondNum = secondPlayer.iterator().next();
            secondPlayer.remove(secondNum);

            if (firstNum > secondNum) {
                firstPlayer.add(firstNum);
                firstPlayer.add(secondNum);
            } else if (secondNum > firstNum) {
                secondPlayer.add(firstNum);
                secondPlayer.add(secondNum);
            }

            if (firstPlayer.isEmpty()) {
                isEmpty = true;
                System.out.println("Second player win!");
            } else if (secondPlayer.isEmpty()) {
                isEmpty = true;
                System.out.println("First player win!");
            }
        }

        if (!isEmpty) {
            if (firstPlayer.size() > secondPlayer.size()) {
                System.out.println("First player win!");
            } else if (secondPlayer.size() > firstPlayer.size()) {
                System.out.println("Second player win!");
            } else {
                System.out.println("Draw");
            }
        }
    }
}
