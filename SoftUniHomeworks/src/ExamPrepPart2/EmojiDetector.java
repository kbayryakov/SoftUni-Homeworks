package ExamPrepPart2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        int threshold = getThreshold(text);

        List<String> emojis = getEmojis(text);

        List<String> coolEmojis = getCoolEmojis(emojis, threshold);

        System.out.println("Cool threshold: " + threshold);
        System.out.printf("%d emojis found in the text. The cool ones are:\n", emojis.size());
        for (String emoji : coolEmojis) {
            System.out.println(emoji);
        }

}

    private static int getThreshold(String text) {
        Pattern pattern = Pattern.compile("\\d");
        Matcher matcher = pattern.matcher(text);

        int sum = 1;
        while (matcher.find()) {
            sum *= Integer.parseInt(matcher.group());
        }
        return sum;
    }

    private static List<String> getEmojis (String text) {
        Pattern pattern = Pattern.compile("(::|\\*\\*)(?<emoji>[A-Z][a-z]{2,})\\1");
        Matcher matcher = pattern.matcher(text);

        List<String> emojis = new ArrayList<>();
        while (matcher.find()) {
            emojis.add(matcher.group());
        }
        return emojis;
    }

    private static List<String> getCoolEmojis(List<String> emojis, int threshold) {
        List<String> coolEmojis = new ArrayList<>();
        for (String emoji : emojis) {
            int sum = 0;
            for (int i = 0; i < emoji.length(); i++) {
                char value = emoji.charAt(i);
                if (Character.isLetter(value)) {
                    sum += value;
                }
            }

            if (sum > threshold) {
                coolEmojis.add(emoji);
            }
        }
        return coolEmojis;
    }
}