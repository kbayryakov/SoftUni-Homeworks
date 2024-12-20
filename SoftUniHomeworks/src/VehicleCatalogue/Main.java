package VehicleCatalogue;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<VehiclesCatalogue> vehiclesList = new ArrayList<>();

        while (!input.equals("End")) {
            String[] vehicleInfo = input.split(" ");

            VehiclesCatalogue vehicle = new VehiclesCatalogue();

            vehicle.setType(vehicleInfo[0]);
            vehicle.setModel(vehicleInfo[1]);
            vehicle.setColour(vehicleInfo[2]);
            vehicle.setHorsepower(Integer.parseInt(vehicleInfo[3]));

            vehiclesList.add(vehicle);

            input = scanner.nextLine();
        }

        int horsePowerSum = 0;
        String model = scanner.nextLine();

        while (!model.equals("Close the Catalogue")) {
            for (VehiclesCatalogue vehicle : vehiclesList) {
                if (vehicle.getModel().equals(model)) {
                    char firstChar = Character.toUpperCase(vehicle.getType().charAt(0));
                    String vehicleType = firstChar + vehicle.getType().substring(1);
                    System.out.println("Type: " + vehicleType);
                    System.out.println("Model: " + vehicle.getModel());
                    System.out.println("Color: " + vehicle.getColour());
                    System.out.println("Horsepower: " + vehicle.getHorsepower());
                }
            }

            model = scanner.nextLine();

        }

        int carsHp = 0;
        int trucksHp = 0;
        int carsNum = 0;
        int trucksNum = 0;

        for (VehiclesCatalogue vehicle : vehiclesList) {
            if (vehicle.getType().equals("car")) {
                carsHp += vehicle.getHorsepower();
                carsNum ++;
            } else if (vehicle.getType().equals("truck")) {
                trucksHp += vehicle.getHorsepower();
                trucksNum ++;
            }
        }

        if (carsNum == 0) {
            System.out.printf("Cars have average horsepower of: %.2f.%n", 0.0);
        } else {
            System.out.printf("Cars have average horsepower of: %.2f.%n",(double) carsHp / carsNum);
        }

        if (trucksNum == 0) {
            System.out.printf("Trucks have average horsepower of: %.2f.%n", 0.0);
        } else {
            System.out.printf("Trucks have average horsepower of: %.2f.%n",(double) trucksHp / trucksNum);
        }

    }
}
