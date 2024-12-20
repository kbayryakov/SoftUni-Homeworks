import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if (command.contains("Add")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                numbers.add(index);
            } else if (command.contains("Insert")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                int index = Integer.parseInt(command.split(" ")[2]);
                if (index >= numbers.size() || index < 0) {
                    System.out.println("Invalid index");
                } else {
                    numbers.add(index, number);
                }
            } else if (command.contains("Remove")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                if (index >= numbers.size() || index < 0) {
                    System.out.println("Invalid index");
                } else {
                    numbers.remove(index);
                }
            } else if (command.contains("Shift left")) {
                int index = Integer.parseInt(command.split(" ")[2]);
                for (int i = 0; i < index; i++) {
                    numbers.add(numbers.get(0));
                    numbers.remove(0);
                }
            } else if (command.contains("Shift right")) {
                int index = Integer.parseInt(command.split(" ")[2]);
                for (int i = 0; i < index; i++) {
                    numbers.add(0, numbers.get(numbers.size() - 1));
                    numbers.remove(numbers.size() - 1);
                }
            }
            command = scanner.nextLine();
        }
        for (Integer num : numbers) {
            System.out.print(num + " ");
        }
    }
}
