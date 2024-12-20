package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> opStack = new ArrayDeque<>();

        for (int i = 0; i < input.length; i++) {

            if (isAlphaNumeric(input[i])) {
                queue.offer(input[i]);
            } else if (input[i].equals("+") || input[i].equals("-") || input[i].equals("*") || input[i].equals("/")) {
                if (opStack.isEmpty()) {
                    opStack.push(input[i]);
                } else {
                    if ((input[i].equals("+") || input[i].equals("-"))) {
                        while (!opStack.isEmpty()) {
                            queue.offer(opStack.pop());
                        }
                        opStack.push(input[i]);
                    } else {
                        opStack.push(input[i]);
                    }
                }
            } else if (input[i].equals("(")) {
                String operator = "";
                while (!input[i].equals(")")) {
                    if (isAlphaNumeric(input[i + 1])) {
                        queue.offer(input[i + 1]);
                    } else if (input[i + 1].equals("+") || input[i + 1].equals("-") || input[i + 1].equals("*") || input[i + 1].equals("/")) {
                        operator = input[i + 1];
                    }
                    i++;
                }
                queue.offer(operator);
            }

        }

        while (!opStack.isEmpty()) {
            queue.offer(opStack.pop());
        }

        while (!queue.isEmpty()) {
            System.out.print(queue.poll() + " ");
        }

    }

    public static boolean isAlphaNumeric (String input) {
        for (char c : input.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) {
                return false;
            }
        }
        return true;
    }
}
