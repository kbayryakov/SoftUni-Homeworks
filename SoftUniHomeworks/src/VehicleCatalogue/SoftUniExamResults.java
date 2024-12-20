package VehicleCatalogue;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        LinkedHashMap<String, Integer> results = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> submissions = new LinkedHashMap<>();

        while (!command.equals("exam finished")) {
            String[] info = command.split("-");

            if (info[1].equals("banned")) {
                results.remove(info[0]);
                command = scanner.nextLine();
                continue;
            }

            if (!results.containsKey(info[0])) {
                results.put(info[0], Integer.parseInt(info[2]));
            } else {
                if (results.get(info[0]) < Integer.parseInt(info[2])) {
                    results.put(info[0], Integer.parseInt(info[2]));
                }
            }

            if (!submissions.containsKey(info[1])) {
                submissions.put(info[1], 1);
            } else {
                submissions.put(info[1], submissions.get(info[1]) + 1);
            }

            command = scanner.nextLine();
        }

        System.out.println("Results:");
        for (Map.Entry<String, Integer> kvp : results.entrySet()) {
            System.out.printf("%s | %d%n", kvp.getKey(), kvp.getValue());
        }

        System.out.println("Submissions:");
        for (Map.Entry<String, Integer> kvp : submissions.entrySet()) {
            System.out.printf("%s - %d%n", kvp.getKey(), kvp.getValue());
        }
    }
}
