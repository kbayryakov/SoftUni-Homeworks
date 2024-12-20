package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = true;

        for (int i = 0; i < input.length(); i++) {

            char symbol = input.charAt(i);

            if (input.charAt(i) == '(' || input.charAt(i) == '{' || input.charAt(i) == '[') {
                stack.push(symbol);
            } else if (input.charAt(i) == ')' || input.charAt(i) == '}' || input.charAt(i) == ']') {
                if (stack.isEmpty()) {
                    isBalanced = false;
                    break;
                }

                if (stack.peek() == '(' && symbol == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && symbol == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && symbol == '}') {
                    stack.pop();
                } else {
                    isBalanced = false;
                    break;
                }
            }

        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
