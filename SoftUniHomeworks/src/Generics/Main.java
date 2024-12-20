package Generics;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> ints = List.of(1, 2, 3);
        List<String> strings = List.of("a", "b", "c");

        int min = ListUtils.getMin(ints);
        String max = ListUtils.getMax(strings);

        System.out.printf("Min %d   Max %s", min, max);
    }
}
