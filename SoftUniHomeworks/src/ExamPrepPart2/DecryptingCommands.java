package ExamPrepPart2;

import java.util.Scanner;

public class DecryptingCommands {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String action;
        while (!"Finish".equals(action = scanner.nextLine())) {

            String[] commands = action.split(" ");
            String command = commands[0];

            if (command.equals("Replace")) {
                String currChar = commands[1];
                String newChar = commands[2];
                text = text.replace(currChar, newChar);
                System.out.println(text);
            } else if (command.equals("Cut")) {
                int startIndex = Integer.parseInt(commands[1]);
                int endIndex = Integer.parseInt(commands[2]);
                if (startIndex >= 0 && endIndex < text.length()) {
                    String subString1 = text.substring(0, startIndex);
                    String subString2 = text.substring(endIndex + 1);
                    text = subString1.concat(subString2);
                    System.out.println(text);
                } else {
                    System.out.println("Invalid indices!");
                }
            } else if (command.equals("Make")) {
                String type = commands[1];
                if (type.equals("Upper")) {
                    text = text.toUpperCase();
                } else if (type.equals("Lower")) {
                    text = text.toLowerCase();
                }
                System.out.println(text);
            } else if (command.equals("Check")) {
                String checked = commands[1];
                if (text.contains(checked)) {
                    System.out.printf("Message contains %s\n", checked);
                } else {
                    System.out.printf("Message doesn't contain %s\n", checked);
                }
            } else if (command.equals("Sum")) {
                int startIndex = Integer.parseInt(commands[1]);
                int endIndex = Integer.parseInt(commands[2]);
                if (startIndex >= 0 && endIndex < text.length()) {
                    String subString = text.substring(startIndex, endIndex + 1);
                    int sum = 0;
                    for (int i = 0; i < subString.length(); i++) {
                        char symbol = subString.charAt(i);
                        sum += (int) symbol;
                    }
                    System.out.println(sum);
                } else {
                    System.out.println("Invalid indices!");
                }
            }

        }
    }
}
