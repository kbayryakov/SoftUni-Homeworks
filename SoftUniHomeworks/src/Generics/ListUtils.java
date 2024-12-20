package Generics;

import java.util.List;

public class ListUtils {

    public static <T extends Comparable <T>> T getMin (List<T> arr) {
        if (arr.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return arr.stream().min(Comparable::compareTo).get();
        }
    }

    public static <T extends Comparable <T>> T getMax (List<T> arr) {
        if (arr.isEmpty()) {
            throw new IllegalArgumentException();
        } else {
            return arr.stream().max(Comparable::compareTo).get();
        }
    }
}
