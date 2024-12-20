package SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> usernames = new LinkedHashSet<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String word = scanner.nextLine();
            usernames.add(word);
        }

        for (String user : usernames) {
            System.out.println(user);
        }
    }
}
