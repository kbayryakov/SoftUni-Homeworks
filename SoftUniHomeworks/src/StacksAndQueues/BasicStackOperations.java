package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] indexes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int pushNums = indexes[0];
        int popNums = indexes[1];
        int numForCheck = indexes[2];

        int[] nums = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(e -> Integer.parseInt(e)).toArray();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        for (Integer num : nums) {
            numbers.push(num);
        }

        for (int i = 1; i <= popNums; i++) {
            numbers.pop();
        }

        boolean contains = numbers.contains(numForCheck);

        if (!numbers.isEmpty()) {
            if (contains) {
                System.out.println(contains);
            } else {
                int minNum = Integer.MAX_VALUE;
                while (!numbers.isEmpty()) {
                    int currNum = numbers.pop();
                    if (minNum > currNum) {
                        minNum = currNum;
                    }
                }
                System.out.println(minNum);
            }
        } else {
            System.out.println(0);
        }
    }
}
