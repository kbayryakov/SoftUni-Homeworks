package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        ArrayDeque<String> browser = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        while (!"Home".equals(input = scanner.nextLine())) {

            if (input.equals("back")) {
                if (browser.size() <= 1) {
                    System.out.println("no previous URLs");
                } else {
                    String currURL = browser.pop();
                    forward.push(currURL);
                    System.out.println(browser.peek());
                }
            } else if (input.equals("forward")) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                } else {
                    String currForward = forward.pop();
                    System.out.println(currForward);
                    browser.push(currForward);
                }
            } else {
                browser.push(input);
                System.out.println(input);
                forward.clear();
            }
        }
    }
}
