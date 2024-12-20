package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Long> fibonacci = new ArrayDeque<>();

        long result = fib(fibonacci, n);

        System.out.println(result);
    }

    public static long fib (ArrayDeque<Long> fibonacci, int n){
        if (n < 2) {
            return 1;
        } else {
            fibonacci.offer(0L);
            fibonacci.offer(1L);

            for (int i = 0; i <= n; i++) {
                long sum = fibonacci.poll() + fibonacci.peek();
                fibonacci.offer(sum);
            }
            return fibonacci.peek();
        }
    }
}
