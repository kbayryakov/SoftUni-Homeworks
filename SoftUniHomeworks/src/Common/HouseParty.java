import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> guests = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();

            if (input.contains("is not going")) {
                String name = input.split(" ")[0];
                if (!guests.contains(name)) {
                    System.out.printf("%s is not in the list!%n", name);
                } else {
                    guests.remove(name);
                }
            } else if (input.contains("is going")) {
                String name = input.split(" ")[0];
                if (guests.contains(name)) {
                    System.out.printf("%s is already in the list!%n", name);
                } else {
                    guests.add(name);
                }
            }
        }

        for (String guest : guests) {
            System.out.println(guest);
        }

    }
}
