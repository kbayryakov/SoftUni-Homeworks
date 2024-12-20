package ExamPrepPart2;

import java.util.*;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command;
        Map<String, Integer> citiesAndPeople = new LinkedHashMap<>();
        Map<String, Integer> citiesAndGold = new LinkedHashMap<>();

        while (!"Sail".equals(command = scanner.nextLine())) {

            String[] commands = command.split("\\|\\|");
            String city = commands[0];
            int population = Integer.parseInt(commands[1]);
            int gold = Integer.parseInt(commands[2]);

            if (!citiesAndPeople.containsKey(city)) {
                citiesAndPeople.put(city, 0);
            }
            citiesAndPeople.put(city, citiesAndPeople.get(city) + population);

            if (!citiesAndGold.containsKey(city)) {
                citiesAndGold.put(city, 0);
            }
            citiesAndGold.put(city, citiesAndGold.get(city) + gold);

        }

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] events = input.split("=>");
            String event = events[0];

            if (event.equals("Plunder")) {
                String town = events[1];
                int people = Integer.parseInt(events[2]);
                int gold = Integer.parseInt(events[3]);

                int peopleLeft = citiesAndPeople.get(town) - people;
                int goldLeft = citiesAndGold.get(town) - gold;

                System.out.printf("%s plundered! %d gold stolen, %d citizens killed.\n", town, gold, people);
                if (peopleLeft <= 0 || goldLeft <=0) {
                    citiesAndPeople.remove(town);
                    citiesAndGold.remove(town);
                    System.out.printf("%s has been wiped off the map!\n", town);
                } else {
                    citiesAndPeople.put(town, peopleLeft);
                    citiesAndGold.put(town, goldLeft);
                }
            } else if (event.equals("Prosper")) {
                String town = events[1];
                int gold = Integer.parseInt(events[2]);

                if (gold >= 0) {
                    int goldAmount = citiesAndGold.get(town) + gold;
                    citiesAndGold.put(town, goldAmount);
                    System.out.printf("%d gold added to the city treasury. %s now has %s gold.\n", gold, town, goldAmount);
                } else {
                    System.out.println("Gold added cannot be a negative number!");
                }
            }

        }

        Map<String, List<Integer>> citiesLeft = new LinkedHashMap<>();
        if (citiesAndPeople.isEmpty() && citiesAndGold.isEmpty()) {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        } else {
            for (Map.Entry<String, Integer> kvp : citiesAndPeople.entrySet()) {
                if (!citiesLeft.containsKey(kvp.getKey())) {
                    citiesLeft.put(kvp.getKey(), new ArrayList<>());
                }
                citiesLeft.get(kvp.getKey()).add(kvp.getValue());
            }

            for (Map.Entry<String, Integer> kvp : citiesAndGold.entrySet()) {
                citiesLeft.get(kvp.getKey()).add(kvp.getValue());
            }

            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:\n", citiesLeft.size());
            for (Map.Entry<String, List<Integer>> kvp : citiesLeft.entrySet()) {
                System.out.printf("%s -> Population: %d citizens, Gold: %d kg\n", kvp.getKey(), kvp.getValue().get(0), kvp.getValue().get(1));
            }
        }
    }
}
