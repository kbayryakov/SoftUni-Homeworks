import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> commands = Arrays
                .stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());
        
        int currentHealth = 100;
        int bitcoins = 0;
        boolean isDead = false;

        for (int i = 0; i < commands.size(); i++) {
            if (commands.get(i).contains("potion")) {
                int healed = Integer.parseInt(commands.get(i).split(" ")[1]);
                if (currentHealth + healed > 100) {
                    System.out.printf("You healed for %d hp.%n", 100 - currentHealth);
                    currentHealth = 100;
                    System.out.printf("Current health: %d hp.%n", currentHealth);
                } else {
                    currentHealth += healed;
                    System.out.printf("You healed for %d hp.%n", healed);
                    System.out.printf("Current health: %d hp.%n", currentHealth);
                }
            } else if (commands.get(i).contains("chest")) {
                int amount = Integer.parseInt(commands.get(i).split(" ")[1]);
                bitcoins += amount;
                System.out.printf("You found %d bitcoins.%n", amount);
            } else {
                String monsterType = commands.get(i).split(" ")[0];
                int attackOfTheMonster = Integer.parseInt(commands.get(i).split(" ")[1]);

                if (currentHealth - attackOfTheMonster > 0) {
                    currentHealth -= attackOfTheMonster;
                    System.out.printf("You slayed %s.%n", monsterType);
                } else {
                    isDead = true;
                    System.out.printf("You died! Killed by %s.%n", monsterType);
                    System.out.printf("Best room: %d%n", i + 1);
                    break;
                }
            }
        }

        if (!isDead) {
            System.out.println("You've made it!");
            System.out.printf("Bitcoins: %d%n", bitcoins);
            System.out.printf("Health: %d%n", currentHealth);
        }
    }
}
