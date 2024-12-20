package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        char[] symbols = text.toCharArray();

        Map<Character, Integer> symbolsList = new TreeMap<>();

        for (int i = 0; i < symbols.length; i++) {
            if (!symbolsList.containsKey(symbols[i])) {
                symbolsList.put(symbols[i], 0);
            }
            symbolsList.put(symbols[i], symbolsList.get(symbols[i]) + 1);

        }

        for (var kvp : symbolsList.entrySet()) {
            System.out.printf("%c: %d time/s\n", kvp.getKey(), kvp.getValue());
        }
    }
}
