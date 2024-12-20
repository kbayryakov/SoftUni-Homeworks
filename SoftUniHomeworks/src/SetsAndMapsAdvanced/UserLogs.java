package SetsAndMapsAdvanced;

import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Map<String, Map<String, List<String>>> userLogs = new TreeMap<>();

        while (!"end".equals(input = scanner.nextLine())) {

            String IP = input.split("\\s+")[0].split("=")[1];
            String message = input.split("\\s+")[1].split("=")[1];
            String user = input.split("\\s+")[2].split("=")[1];

            if (!userLogs.containsKey(user)) {
                userLogs.put(user, new LinkedHashMap<>());
            }

            if (!userLogs.get(user).containsKey(IP)) {
                userLogs.get(user).put(IP, new ArrayList<>());
            }
            userLogs.get(user).get(IP).add(message);

        }

        for (var kvp : userLogs.entrySet()) {

            System.out.printf("%s: \n", kvp.getKey());

            int counter = 1;
            for (var kvp2 : kvp.getValue().entrySet()) {
                if (counter == kvp.getValue().size()) {
                    System.out.printf("%s => %d.\n", kvp2.getKey(), kvp2.getValue().size());
                } else {
                    System.out.printf("%s => %d, ", kvp2.getKey(), kvp2.getValue().size());
                }
                counter++;
            }

        }
    }
}
