package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());
        PriorityQueue<String> names = new PriorityQueue<>();
        Collections.addAll(names, input);
        int cycle = 1;

        while (names.size() > 1) {

            for (int i = 1; i < n; i++) {
                names.offer(names.poll());
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + names.peek());
            } else {
                System.out.println("Removed " + names.poll());
            }

            cycle++;
        }

        System.out.println("Last is " + names.poll());
    }

    public static boolean isPrime (int number) {
        if (number <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number) ; i++) {
            if (number % i == 0) {
                return  false;
            }
        }

        return true;

    }
}

