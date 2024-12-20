import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> inventory = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Craft!")) {
            if (command.contains("Collect")) {
                String item = command.split(" - ")[1];
                if (!inventory.contains(item)) {
                    inventory.add(item);
                }
            } else if (command.contains("Drop")) {
                String item = command.split(" - ")[1];
                inventory.remove(item);
            } else if (command.contains("Combine Items")) {
                String items = command.split(" - ")[1];
                String oldItem = items.split(":")[0];
                String newItem = items.split(":")[1];
                if (inventory.contains(oldItem)) {
                    int index = inventory.indexOf(oldItem);
                    inventory.add(index + 1, newItem);
                }
            } else if (command.contains("Renew")) {
                String item = command.split(" - ")[1];
                if (inventory.contains(item)) {
                    inventory.remove(item);
                    inventory.add(item);
                }
            }

            command = scanner.nextLine();

        }

        System.out.println(String.join(", ", inventory));

    }
}

