import java.util.Arrays;
import java.util.Scanner;

public class TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());

        int[] wagons = Arrays
                .stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int peopleOnTheCurrentWagon = 0;
        int peopleOnTheLift = 0;
        boolean noMorePeople = false;
        int liftCapacity = wagons.length * 4;

        for (int i = 0; i < wagons.length; i++) {
            while (wagons[i] < 4) {
                wagons[i] ++;
                peopleOnTheCurrentWagon ++;
                if (peopleOnTheLift + peopleOnTheCurrentWagon == people) {
                    noMorePeople = true;
                    break;
                }
            }
            peopleOnTheLift += peopleOnTheCurrentWagon;
            peopleOnTheCurrentWagon = 0;
            if (noMorePeople) {
                break;
            }
        }

        int sumOfPeopleOnTheLift = Arrays.stream(wagons).sum();
        if (sumOfPeopleOnTheLift < liftCapacity && noMorePeople) {
            System.out.println("The lift has empty spots!");
            for (int wagon : wagons) {
                System.out.print(wagon + " ");
            }
        } else if (people > peopleOnTheLift) {
            System.out.printf("There isn't enough space! %d people in a queue!%n", people - peopleOnTheLift);
            for (int wagon : wagons) {
                System.out.print(wagon + " ");
            }
        } else if (sumOfPeopleOnTheLift == liftCapacity && noMorePeople) {
            for (int wagon : wagons) {
                System.out.print(wagon + " ");
            }
        }

    }
}
