package FunctionalProgramming;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();
        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split(",\\s+");
            String person = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            people.put(person, age);
        }

        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        BiFunction<String, Integer, Predicate<Integer>> predicateFactory = (con, ag) -> {
            if ("younger".equals(con)) {
                return a -> a <= ag;
            } else {
                return a -> a >= ag;
            }
        };

        Map<String, Integer> filtered = people.entrySet().stream()
                .filter(e -> predicateFactory.apply(condition, age).test(e.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Function<String, Consumer<Map.Entry<String, Integer>>> consumerFactory = a -> {
                switch (a) {
                    case "name":
                        return m -> System.out.println(m.getKey());
                    case "age":
                        return m -> System.out.println(m.getValue());
                    default:
                        return m -> System.out.println(m.getKey() + " - " + m.getValue());
                }
        };

        people.entrySet().stream()
                .filter(e -> predicateFactory.apply(condition, age).test(e.getValue()))
                .forEach(e -> consumerFactory.apply(format).accept(e));
    }
}
