package Common;

import java.util.Scanner;

public class ComputerStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;
        double taxes = 0;
        String customer = "";

        while (!input.equals("special") && !input.equals("regular")) {

            double givenPrice = Double.parseDouble(input);

            if (givenPrice > 0) {
                sum += givenPrice;
            } else {
                System.out.println("Invalid price!");
            }

            input = scanner.nextLine();
            customer = input;
        }

        if (sum <= 0) {
            System.out.println("Invalid order!");
            return;
        }

        taxes = 0.2 * sum;
        double finalSum = sum + taxes;
        if (customer.equals("special")) {
            finalSum -= finalSum * 0.10;
        }

        System.out.println("Congratulations you've just bought a new computer!");
        System.out.printf("Price without taxes: %.2f$%n", sum);
        System.out.printf("Taxes: %.2f$%n", taxes);
        System.out.println("-----------");
        System.out.printf("Total price: %.2f$%n", finalSum);

    }
}
