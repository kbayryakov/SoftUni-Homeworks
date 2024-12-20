package ExamPrepPart2;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String message = scanner.nextLine();

        String command = "";

        while (!"Reveal".equals(command = scanner.nextLine())) {
            String[] commands = command.split(":\\|:");
            String instruction = commands[0];

            if (instruction.equals("InsertSpace")) {
                int index = Integer.parseInt(commands[1]);
                String substring1 = message.substring(0, index);
                String substring2 = message.substring(index);
                message = substring1.concat(" ").concat(substring2);
                System.out.println(message);
            } else if (instruction.equals("Reverse")) {
                String text = commands[1];
                if (message.contains(text)) {
                    int startIndex = message.indexOf(text);
                    int endIndex = text.length() + startIndex;
                    String substring1 = message.substring(0, startIndex);
                    String substring2 = message.substring(endIndex);
                    StringBuilder reversed = new StringBuilder(text);
                    reversed.reverse();
                    message = substring1.concat(substring2).concat(String.valueOf(reversed));
                    System.out.println(message);
                } else {
                    System.out.println("error");
                }
            } else if (instruction.equals("ChangeAll")) {
                String oldText = commands[1];
                String newText = commands[2];
                message = message.replace(oldText, newText);
                System.out.println(message);
            }
        }

        System.out.printf("You have a new text message: %s", message);

    }
}
