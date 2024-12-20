package HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(input[0]);

        int daysNum = Integer.parseInt(input[1]);

        Season season = Season.valueOf(input[2].toUpperCase());

        if (input[3].equalsIgnoreCase("SECONDVISIT")) {
            input[3] = "SECOND_VISIT";
        }
        Discount discountType = Discount.valueOf(input[3].toUpperCase());


        System.out.printf("%.2f", PriceCalculator.calculatePrice(daysNum, pricePerDay, season, discountType));

    }
}
