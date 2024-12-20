package OpinionPoll2;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);

            people.add(person);
        }

        people.stream().filter(person -> person.getAge() > 30)
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(System.out::println);
    }
}
