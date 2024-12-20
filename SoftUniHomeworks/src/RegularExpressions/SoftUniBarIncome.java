package RegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;

        while (!input.equals("end of shift")) {

            Pattern pattern = Pattern.compile("%(?<name>[A-z][a-z]+)%[^|$%.]*<(?<product>[\\w]+)>[^|$%.]*\\|(?<quantity>[\\d]+)\\|[^|$%.]*?(?<price>[\\d]+\\.?[\\d]+?)\\$");
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {

                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("quantity"));
                double price = Double.parseDouble(matcher.group("price"));

                System.out.printf("%s: %s - %.2f\n", name, product, price * quantity);
                sum += quantity * price;

            }

            input = scanner.nextLine();

        }

        System.out.printf("Total income: %.2f", sum);

    }
}
