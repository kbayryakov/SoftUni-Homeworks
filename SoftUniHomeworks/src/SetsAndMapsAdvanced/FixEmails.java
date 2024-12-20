package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        int counter = 0;
        Map<String, String> emailList = new LinkedHashMap<>();
        Map<String, String> newList = new LinkedHashMap<>();
        String name = "";
        String email = "";

        while (!"stop".equals(input = scanner.nextLine())) {
            if (counter % 2 == 0) {
                name = input;
            } else {
                email = input.toLowerCase();
            }

            emailList.put(name, email);
            counter++;
        }

        for (var kvp : emailList.entrySet()) {
            String substring = kvp.getValue().split("@")[1];
            String domain = substring.split("\\.")[1];

            if (!domain.equals("us") && !domain.equals("uk") && !domain.equals("com")) {
                newList.put(kvp.getKey(), kvp.getValue());
            }
        }

        for (var kvp : newList.entrySet()) {
            System.out.printf("%s -> %s\n", kvp.getKey(), kvp.getValue());
        }
    }
}
