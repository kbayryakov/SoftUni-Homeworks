package BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        List<Identifiable> identifiableObjects = new ArrayList<>();

        while (!"End".equalsIgnoreCase(command = scanner.nextLine())) {
            String[] commands = command.split("\\s+");

            if (commands.length > 2) {
                String name = commands[0];
                int age = Integer.parseInt(commands[1]);
                String id = commands[2];
                Identifiable citizen = new Citizen(name, age, id);
                identifiableObjects.add(citizen);
            } else {
                Identifiable robot = new Robot(commands[1], commands[0]);
                identifiableObjects.add(robot);
            }
        }

        String fakeId = scanner.nextLine();

        identifiableObjects.stream().filter(i -> i.getId().endsWith(fakeId)).forEach(i -> System.out.println(i.getId()));
    }
}
