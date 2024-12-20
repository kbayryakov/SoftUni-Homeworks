package ExamPrepPart2;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String input;
        while (!"Decode".equals(input = scanner.nextLine())) {

            String[] commands = input.split("\\|");
            String command = commands[0];

            if (command.equals("Move")) {
                int num = Integer.parseInt(commands[1]);
                String textForMove = text.substring(0, num);
                String textLeft = text.substring(num);
                text = textLeft + textForMove;
            } else if (command.equals("Insert")) {
                int index = Integer.parseInt(commands[1]);
                String value = commands[2];
                String subString1 = text.substring(0, index);
                String subString2 = text.substring(index);
                text = subString1 + value + subString2;
            } else if (command.equals("ChangeAll")) {
                String substring = commands[1];
                String replacement = commands[2];
                text = text.replace(substring, replacement);
            }

        }

        System.out.printf("The decrypted message is: %s", text);

    }
}
