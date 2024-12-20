package OpinionPoll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> personList = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(" ");
            Person person = new Person();
            person.setName(input[0]);
            person.setAge(Integer.parseInt(input[1]));
            personList.add(person);
        }

        for (Person person : personList) {
            if (person.getAge() > 30) {
                System.out.printf("%s - %s%n", person.getName(), person.getAge());
            }
        }

    }
}
