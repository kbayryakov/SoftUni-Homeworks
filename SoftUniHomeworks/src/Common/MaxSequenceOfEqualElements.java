import java.util.Arrays;
import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int startIndex = 0;
        int maxSequence = 0;
        int currentIndex = 0;
        int currentSequence = 0;
        int finalIndex = 0;

        for (int i = 0; i < numbers.length -1; i++) {
            if (numbers[i] == numbers[i + 1]) {
                currentIndex = i + 1;
                currentSequence ++;
            } else {
                currentSequence = 0;
            }

            if (currentSequence > maxSequence) {
                finalIndex = currentIndex;
                maxSequence = currentSequence;
            }
        }

        startIndex = finalIndex - maxSequence;
        for (int i = finalIndex; i >= startIndex; i--) {
            System.out.print(numbers[i] + " ");
        }

    }
}
