import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .collect(Collectors.toList());

        int bomb = Integer.parseInt(scanner.next());
        int power = Integer.parseInt(scanner.next());

        while (numbers.contains(bomb)) {
            int bombIndex = numbers.indexOf(bomb);

            int left = Math.max(0, bombIndex - power);
            int right = Math.min(bombIndex + power, numbers.size() - 1);

            for (int i = right; i >= left; i--) {
                numbers.remove(i);
            }
        }
        int sum = 0;
        for (int i = 0; i < numbers.size(); i++) {
            sum += numbers.get(i);
        }
        System.out.println(sum);
    }
}
