package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(e -> Integer.parseInt(e))
                .toArray();

        int elementsNum = indexes[0];
        int removed = indexes[1];
        int elementForCheck = indexes[2];
        boolean isPresent = false;

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int number : numbers) {
            queue.offer(number);
        }

        for (int i = 1; i <= removed; i++) {
            queue.poll();
        }

        if (queue.contains(elementForCheck)) {
            isPresent = true;
            System.out.println(isPresent);
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                int smallest = Collections.min(queue);
                System.out.println(smallest);
            }

        }
    }
}
