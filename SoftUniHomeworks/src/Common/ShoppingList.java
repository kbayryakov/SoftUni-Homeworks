import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> shoppingList = Arrays
                .stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("Go Shopping!")) {
            if (command.contains("Urgent")) {
                String item = command.split(" ")[1];
                if (!shoppingList.contains(item)) {
                    shoppingList.add(0, item);
                }
            } else if (command.contains("Unnecessary")) {
                String item = command.split(" ")[1];
                shoppingList.remove(item);
            } else if (command.contains("Correct")) {
                String oldItem = command.split(" ")[1];
                String newItem = command.split(" ")[2];
                if (shoppingList.contains(oldItem)) {
                    int index = shoppingList.indexOf(oldItem);
                    shoppingList.set(index, newItem);
                }
            } else if (command.contains("Rearrange")) {
                String item = command.split(" ")[1];
                if (shoppingList.contains(item)) {
                    shoppingList.remove(item);
                    shoppingList.add(item);
                }
            }

            command = scanner.nextLine();

        }

        System.out.println(String.join(", ", shoppingList));
    }
}
