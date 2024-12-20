package FunctionalProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int delimiter = Integer.parseInt(scanner.nextLine());

        BiFunction<List<Integer>, Integer, List<Integer>> exclude = (list, n) -> {
            return list.stream().filter(e -> e % n != 0).collect(Collectors.toList());
        };

        Consumer<List<Integer>> print = list -> list.forEach(n -> System.out.print(n + " "));

        Consumer<List<Integer>> reverse = Collections::reverse;

        nums = exclude.apply(nums, delimiter);

        reverse.accept(nums);

        print.accept(nums);
    }
}
