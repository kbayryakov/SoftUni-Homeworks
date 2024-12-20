package FunctionalProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        double[] nums = Arrays.stream(reader.readLine().split(",\\s+"))
                .mapToDouble(n -> Double.parseDouble(n))
                .toArray();

        UnaryOperator<double[]> addVAT = x -> {
            for (int i = 0; i < x.length; i++) {
                x[i] = x[i] * 1.2;
            }
            return x;
        };

        addVAT.apply(nums);

        System.out.println("Prices with VAT:");
        for (double num : nums) {
            System.out.printf("%.2f\n", num);
        }
    }
}
