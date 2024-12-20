import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> targets = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("End")) {
            if (command.contains("Shoot")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int power = Integer.parseInt(command.split(" ")[2]);

                if (index >= 0 && index < targets.size()) {
                    int newValue = targets.get(index) - power;
                    targets.set(index, newValue);
                    if (newValue <= 0) {
                        targets.remove(index);
                    }
                }
            } else if (command.contains("Add")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int value = Integer.parseInt(command.split(" ")[2]);

                if (index >= 0 && index < targets.size()) {
                    targets.add(index, value);
                } else {
                    System.out.println("Invalid placement!");
                }
            } else if (command.contains("Strike")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int radius = Integer.parseInt(command.split(" ")[2]);

                if (index - radius >= 0 && index + radius < targets.size()) {
                    for (int i = index + radius; i >= index - radius; i--) {
                        targets.remove(i);
                    }
                } else {
                    System.out.println("Strike missed!");
                }
            }

            command = scanner.nextLine();

        }

        for (int i = 0; i < targets.size() - 1; i++) {
            System.out.print(targets.get(i) + "|");
        }
        System.out.println(targets.get(targets.size() - 1));

    }
}
