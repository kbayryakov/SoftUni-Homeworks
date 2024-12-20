package RegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List <String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        for (int messages = 1; messages <= n; messages++) {

            String encryptedMessage = scanner.nextLine();
            StringBuilder decryptedMessage = new StringBuilder();
            int sum = 0;

            for (int i = 0; i < encryptedMessage.length(); i++) {
                char symbol = encryptedMessage.charAt(i);

                if (symbol == 's' || symbol == 't' || symbol == 'a' || symbol == 'r' || symbol == 'S'
                        || symbol == 'T' || symbol == 'A' || symbol == 'R') {
                    sum++;
                }

            }

            for (int i = 0; i < encryptedMessage.length(); i++) {
                char newSymbol = (char) ((int) encryptedMessage.charAt(i) - sum);
                decryptedMessage.append(newSymbol);
            }

            Pattern pattern = Pattern.compile("@(?<planet>[A-z]+)[^@\\-!:>]*:(?<population>[\\d]+)[^@\\-!:>]*!(?<attack>[[A]|[D]])![^@\\-!:>]*->(?<soldierCount>[\\d]+)");
            Matcher matcher = pattern.matcher(decryptedMessage);

            if (matcher.find()) {
                if (matcher.group("attack").equals("A")) {
                    attackedPlanets.add(matcher.group("planet"));
                } else if (matcher.group("attack").equals("D")) {
                    destroyedPlanets.add(matcher.group("planet"));
                }
            }

        }

        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);

        System.out.println("Attacked planets: " + attackedPlanets.size());
        if (!attackedPlanets.isEmpty()) {
            for (String planet : attackedPlanets) {
                System.out.println("-> " + planet);
            }
        }

        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        if (!destroyedPlanets.isEmpty()) {
            for (String planet : destroyedPlanets) {
                System.out.println("-> " + planet);
            }
        }
    }
}