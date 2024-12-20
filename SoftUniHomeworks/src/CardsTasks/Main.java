package CardsTasks;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = new String[2];

        for (int i = 0; i < input.length; i++) {
            input[i] = scanner.nextLine();
        }

        Cards card = Cards.valueOf(input[0]);
        Suits suit = Suits.valueOf((input[1]));

        System.out.printf("Card name: %s of %s; Card power: %d",
                card.name(), suit.name(), card.getRankPower() + suit.getSuitPower());
    }
}
