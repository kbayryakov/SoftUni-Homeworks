package ExamPrepPart2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        Pattern pattern = Pattern
                .compile("(#|\\|)(?<food>[A-za-z\\s]+)\\1(?<date>[0-9]{2}\\/[0-9]{2}\\/[0-9]{2})\\1(?<cal>[0-9]{1,5})\\1");

        Matcher matcher = pattern.matcher(text);

        int totalCal = 0;
        List<String> foodList = new ArrayList<>();
        while (matcher.find()) {
            totalCal += Integer.parseInt(matcher.group("cal"));
            String food = String.format("Item: %s, Best before: %s, Nutrition: %s"
                    , matcher.group("food"), matcher.group("date"), matcher.group("cal"));

            foodList.add(food);
        }

        System.out.printf("You have food to last you for: %d days!\n", totalCal / 2000);
        for (String item : foodList) {
            System.out.println(item);
        }

    }
}
