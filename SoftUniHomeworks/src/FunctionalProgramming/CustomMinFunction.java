package FunctionalProgramming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Function<Integer[], Integer> findMin = arr -> Arrays.stream(arr).min(Integer::compareTo).get();

        System.out.println(findMin.apply(nums));

    }
}
