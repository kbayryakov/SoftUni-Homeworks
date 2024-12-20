package ExamPrepPart2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String text = scanner.nextLine();

            Pattern pattern = Pattern.compile("!(?<command>[A-Z][a-z]{2,})!:\\[(?<message>[A-z]{8,})\\]");
            Matcher matcher = pattern.matcher(text);

            if (matcher.find()) {
                String command = matcher.group("command");
                String message = matcher.group("message");

                StringBuilder translatedMessage = new StringBuilder();
                for (int j = 0; j < message.length(); j++) {
                    int value = message.charAt(j);
                    translatedMessage.append(value).append(" ");
                }
                System.out.printf("%s: %s\n", command, translatedMessage.toString());
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}
