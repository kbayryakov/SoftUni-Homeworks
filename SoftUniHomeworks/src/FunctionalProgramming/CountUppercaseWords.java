package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Predicate<String> isUpper = s -> Character.isUpperCase(s.charAt(0));
        Consumer<String> print = s -> System.out.println(s);

        List<String> words = Arrays.stream(reader.readLine().split("\\s+"))
                .filter(isUpper)
                .collect(Collectors.toList());

        print.accept(String.valueOf(words.size()));

        words.forEach(print);
    }
}
