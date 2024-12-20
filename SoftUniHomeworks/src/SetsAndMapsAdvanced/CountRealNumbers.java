package SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] nums = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();

        Map<Double, Integer> numbers = new LinkedHashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!numbers.containsKey(nums[i])) {
                numbers.put(nums[i], 0);
            }

            numbers.put(nums[i], numbers.get(nums[i]) + 1);
        }

        for (Map.Entry<Double, Integer> kvp : numbers.entrySet()) {
            System.out.printf("%.1f -> %d\n", kvp.getKey(), kvp.getValue());
        }
    }

}
