import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int leftSum = 0;
        int rightSum = 0;
        boolean elementExists = false;

        for (int i = 0; i <= numbers.length - 1; i++) {

            for (int j = 0; j < i; j++) {
                leftSum += numbers[j];
            }

            for (int j = numbers.length - 1; j > i; j--) {
                rightSum += numbers[j];
            }

            if (leftSum == rightSum) {
                System.out.println(i);
                elementExists = true;
                break;
            }
            leftSum =0;
            rightSum = 0;
        }

        if (!elementExists) {
            System.out.println("no");
        }

    }
}
