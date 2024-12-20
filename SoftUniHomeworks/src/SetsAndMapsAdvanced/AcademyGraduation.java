package SetsAndMapsAdvanced;

import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> academy = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();

            if (!academy.containsKey(name)) {
                academy.put(name, new ArrayList<>());
            }

            for (double grade : grades) {
                academy.get(name).add(grade);
            }
        }

        for (var kvp : academy.entrySet()) {
            double sum = 0;
            int gradesCount = kvp.getValue().size();
            for (Double grade : kvp.getValue()) {
                sum += grade;
            }
            System.out.printf("%s is graduated with %s\n", kvp.getKey(), new DecimalFormat("0.##############################")
                    .format(sum / gradesCount));
        }
    }
}
