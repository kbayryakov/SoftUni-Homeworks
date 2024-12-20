package Cars;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Car car = null;

            if (input.length == 1) {
                car = new Car(input[0]);
            } else {
                String brand = input[0];
                String model = input[1];
                int horsePower = Integer.parseInt(input[2]);
                car = new Car(brand, model, horsePower);
            }
            cars.add(car);
        }

        cars.forEach(car -> {
            System.out.println(car.carInfo());
        });
    }
}
