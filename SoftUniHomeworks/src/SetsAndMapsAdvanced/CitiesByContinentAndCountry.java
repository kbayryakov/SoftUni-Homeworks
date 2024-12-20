package SetsAndMapsAdvanced;

import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, List<String>>> places = new LinkedHashMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");

            String continent = input[0];
            String country = input[1];
            String city = input[2];

            if (!places.containsKey(continent)) {
                places.put(continent, new LinkedHashMap<>());
            }

            if (!places.get(continent).containsKey(country)) {
                places.get(continent).put(country, new ArrayList<>());
            }

            places.get(continent).get(country).add(city);

        }

        for (var kvp : places.entrySet()) {
            System.out.printf("%s:\n", kvp.getKey());
            for (var kvp2 : kvp.getValue().entrySet()) {
                System.out.printf("%s -> %s\n", kvp2.getKey(), String.join(", ", kvp2.getValue()));

            }
        }
    }
}
