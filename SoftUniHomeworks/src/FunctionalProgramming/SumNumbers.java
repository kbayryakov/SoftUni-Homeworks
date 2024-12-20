package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Function<String, Integer> parser = x -> Integer.parseInt(x);

        List<Integer> result = Arrays.stream(reader.readLine().split(",\\s+"))
                .map(parser)
                .collect(Collectors.toList());

        int count = result.size();
        int sum = result.stream().mapToInt(x -> x).sum();

        System.out.println("Count = " + count);
        System.out.println("Sum = " + sum);
    }
}
