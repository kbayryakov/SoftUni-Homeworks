package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nums = scanner.nextLine().split("\\s+");
        ArrayDeque<String> numbers = new ArrayDeque<>();

        for (String e : nums) {
            numbers.push(e);
        }

        while (!numbers.isEmpty()) {
            System.out.print(numbers.pop() + " ");
        }
    }
}
