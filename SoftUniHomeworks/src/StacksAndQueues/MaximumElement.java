package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> elements = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            if ("1".equals(command)) {
                int num = Integer.parseInt(input[1]);
                elements.push(num);
            } else if ("2".equals(command)) {
                elements.pop();
            } else if ("3".equals(command)) {
                int maxElement = Collections.max(elements);
                System.out.println(maxElement);
            }
        }
    }
}
