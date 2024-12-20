package TextProcessing;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        StringBuilder result = new StringBuilder();

        for (String element : input) {
            result.append(String.valueOf(element).repeat(element.length()));
        }

        System.out.println(result.toString());
    }
}
