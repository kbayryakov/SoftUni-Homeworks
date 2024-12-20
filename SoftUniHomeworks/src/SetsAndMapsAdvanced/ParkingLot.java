package SetsAndMapsAdvanced;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Set<String> parkingLot = new LinkedHashSet<String>();

        while (!"END".equals(input = scanner.nextLine())) {
            String direction = input.split(",\\s+")[0];
            String carNumber = input.split(",\\s+")[1];

            if ("IN".equals(direction)) {
                parkingLot.add(carNumber);
            } else if ("OUT".equals(direction)) {
                parkingLot.remove(carNumber);
            }
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String carNum : parkingLot) {
                System.out.println(carNum);
            }
        }
    }
}
