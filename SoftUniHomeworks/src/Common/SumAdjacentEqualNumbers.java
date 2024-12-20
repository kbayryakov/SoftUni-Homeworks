import java.util.*;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(e -> Double.parseDouble(e))
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() / 2; i++) {
            if (numbers.get(i).equals(numbers.get(i + 1))) {
                numbers.set(i, numbers.get(i) + numbers.get(i + 1));
                numbers.remove(i + 1);
                i = 0;
            }

        }
    }
}
