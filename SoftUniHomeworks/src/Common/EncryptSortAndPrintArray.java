import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] results = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int result = 0;
            String input = scanner.nextLine();
            for (int j = 0; j < input.length(); j++) {
                char symbol = input.charAt(j);
                if (symbol == 'A' || symbol == 'E' || symbol == 'I' || symbol == 'O' || symbol == 'U'
                || symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u') {
                    result = symbol * input.length();
                } else {
                    result = symbol / input.length();
                }
                sum += result;
            }
            results[i] = sum;
            sum = 0;
        }
        Arrays.sort(results);
        for (int i = 0; i < n; i++) {
            System.out.println(results[i]);
        }
    }
}
