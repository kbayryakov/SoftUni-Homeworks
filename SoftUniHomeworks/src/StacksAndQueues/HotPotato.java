package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> names = new ArrayDeque<>();
        Collections.addAll(names, input);

        while (names.size() > 1) {

            for (int i = 1; i < n; i++) {
                names.offer(names.poll());
            }

            System.out.println("Removed " + names.poll());

        }

        System.out.println("Last is " + names.poll());
    }
}
