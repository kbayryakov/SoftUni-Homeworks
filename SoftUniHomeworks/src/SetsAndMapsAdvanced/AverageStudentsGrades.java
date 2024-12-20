package SetsAndMapsAdvanced;

import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> studentsGrades = new TreeMap<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String student = input[0];
            Double grade = Double.parseDouble(input[1]);

            if (!studentsGrades.containsKey(student)) {
                studentsGrades.put(student, new ArrayList<>());
            }

            studentsGrades.get(student).add(grade);
        }

        for (Map.Entry<String, List<Double>> kvp : studentsGrades.entrySet()) {
            double sum = 0;
            System.out.printf("%s -> ", kvp.getKey());
            for (int i = 0; i < kvp.getValue().size(); i++) {
                System.out.printf("%.2f ", kvp.getValue().get(i));
                sum += kvp.getValue().get(i);
            }
            System.out.printf("(avg: %.2f)", sum / kvp.getValue().size() );
            System.out.println();
        }
    }
}
