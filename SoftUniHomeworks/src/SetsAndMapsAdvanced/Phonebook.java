package SetsAndMapsAdvanced;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        Map<String, String> phoneBook = new HashMap<>();

        while (!"search".equals(command = scanner.nextLine())) {
            String name = command.split("-")[0];
            String num = command.split("-")[1];

            phoneBook.put(name, num);
        }

        String search;
        while (!"stop".equals(search = scanner.nextLine())) {
            if (phoneBook.containsKey(search)) {
                System.out.print(search + " ->" + " ");
                System.out.println(phoneBook.get(search));
            } else {
                System.out.printf("Contact %s does not exist.\n", search);
            }
        }
    }
}
