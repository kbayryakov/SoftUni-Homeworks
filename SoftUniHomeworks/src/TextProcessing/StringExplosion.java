package TextProcessing;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder input = new StringBuilder(scanner.nextLine());

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '>') {
                for (int j = i; j < i + Integer.parseInt(String.valueOf(input.charAt(i + 1))); j++) {
                    if (input.charAt(j) == '>') {

                    } else {
                        input.deleteCharAt(i);
                    }
                }
            }
        }
    }
}
