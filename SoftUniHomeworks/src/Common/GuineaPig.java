import java.util.Scanner;

public class GuineaPig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double foodInKgs = Double.parseDouble(scanner.nextLine());
        double hayInKgs = Double.parseDouble(scanner.nextLine());
        double coverInKgs = Double.parseDouble(scanner.nextLine());
        double pigsWeight = Double.parseDouble(scanner.nextLine());

        double foodInGrams = foodInKgs * 1000;
        double hayInGrams = hayInKgs * 1000;
        double coverInGrams = coverInKgs * 1000;
        double pigsWeightInGrams = pigsWeight * 1000;
        boolean notEnough = false;

        for (int i = 1; i <= 30; i++) {
            foodInGrams -= 300;

            if (i % 2 == 0) {
                hayInGrams -= 0.05 * foodInGrams;
            }
            if (i % 3 == 0) {
                coverInGrams -= ((double) 1 / 3) * pigsWeightInGrams;
            }

            if (foodInGrams <= 0 || hayInGrams <= 0 || coverInGrams <= 0) {
                notEnough = true;
                break;
            }
        }

        if (!notEnough) {
            System.out.printf("Everything is fine! Puppy is happy! Food: %.2f, Hay: %.2f, Cover: %.2f."
                    , foodInGrams / 1000, hayInGrams / 1000, coverInGrams / 1000);
        } else {
            System.out.println("Merry must go to the pet store!");
        }

    }
}
