package Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Students> studentsList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");

            Students student = new Students();

            student.setFirstName(input[0]);
            student.setSecondName(input[1]);
            student.setGrade(Double.parseDouble(input[2]));

            studentsList.add(student);
        }

        Comparator<Students> gradeComparator = Comparator.comparingDouble(Students -> Students.getGrade());
        studentsList.sort(gradeComparator.reversed());

        for (Students student : studentsList) {
            System.out.printf("%s %s: %.2f%n", student.getFirstName(), student.getSecondName(), student.getGrade());
        }
    }
}
