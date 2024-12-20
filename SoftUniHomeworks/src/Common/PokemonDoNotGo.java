import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDoNotGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> values = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        int index = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        while (!values.isEmpty()) {

            if (index < 0) {
                if (values.size() == 1) {
                    int valueOfIndex = values.get(0);
                    sum += valueOfIndex;
                    values.remove(0);
                    break;
                }
                int valueOfIndex = values.get(0);
                sum += valueOfIndex;
                int lastElement = values.get(values.size() - 1);
                values.set(0, lastElement);

                calculatingNewValues(values, valueOfIndex);

            } else if (index >= values.size()) {
                if (values.size() == 1) {
                    int valueOfIndex = values.get(0);
                    sum += valueOfIndex;
                    values.remove(0);
                    break;
                }
                int valueOfIndex = values.get(values.size() - 1);
                sum += valueOfIndex;
                int firstElement = values.get(0);
                values.remove(values.size() - 1);
                values.add(firstElement);

                calculatingNewValues(values, valueOfIndex);

            } else {
                int valueOfIndex = values.get(index);
                sum += valueOfIndex;
                values.remove(index);

                calculatingNewValues(values, valueOfIndex);

            }

            if (values.isEmpty()) {
                break;
            }
            index = Integer.parseInt(scanner.nextLine());

        }
        System.out.println(sum);
    }
    public static void calculatingNewValues (List<Integer> values, int valueOfIndex) {
        for (int i = 0; i < values.size(); i++) {
            int newValue = 0;
            if (values.get(i) <= valueOfIndex) {
                newValue = values.get(i) + valueOfIndex;
                values.set(i, newValue);
            } else {
                newValue = values.get(i) - valueOfIndex;
                values.set(i, newValue);
            }
        }
    }
}
