package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder text = new StringBuilder();
        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String command = input[0];

            if ("1".equals(command)) {
                stack.push(String.valueOf(text));
                String stringForAppend = input[1];
                text.append(stringForAppend);
            } else if ("2".equals(command)) {
                stack.push(String.valueOf(text));
                int count = Integer.parseInt(input[1]);
                text.delete(text.length() - count,text.length());
            } else if ("3".equals(command)) {
                int index = Integer.parseInt(input[1]);
                if (index >= 0 && index <= text.length()) {
                    System.out.println(text.charAt(index - 1));
                }
            } else if ("4".equals(command)) {
                if (!stack.isEmpty()) {
                    text = new StringBuilder(stack.pop());
                }
            }
        }
    }
}
