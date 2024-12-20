package ExamPrep;

import java.util.*;
import java.util.stream.Collectors;

public class Blacksmith {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> swords = new HashMap<>();
        swords.put(70, "Gladius");
        swords.put(80, "Shamshir");
        swords.put(90, "Katana");
        swords.put(110, "Sabre");

        Deque<Integer> steelQueue = new ArrayDeque<>();
        Deque<Integer> carbonStack = new ArrayDeque<>();

        TreeMap<String, Integer> swordsForged = new TreeMap<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(steelQueue::offer);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(carbonStack::push);

        while (!steelQueue.isEmpty() && !carbonStack.isEmpty()) {
            int steelTaken = steelQueue.poll();
            int carbonTaken = carbonStack.pop();
            int sum = steelTaken + carbonTaken;

            if (swords.containsKey(sum)) {
                String sword = swords.get(sum);
                swordsForged.putIfAbsent(sword, 0);
                swordsForged.put(sword, swordsForged.get(sword) + 1);
            } else {
                carbonTaken += 5;
                carbonStack.push(carbonTaken);
            }
        }

        if (swordsForged.isEmpty()) {
            System.out.println("You did not have enough resources to forge a sword.");
        } else {
            System.out.printf("You have forged %d swords.%n", swordsForged.values().stream().mapToInt(e -> e).sum());
        }
        printDeque(steelQueue, "Steel left: %s%n");
        printDeque(carbonStack, "Carbon left: %s%n");

        for (Map.Entry<String, Integer> kvp : swordsForged.entrySet()) {
            System.out.printf("%s: %d\n", kvp.getKey(), kvp.getValue());
        }
    }
    public static void printDeque (Deque<Integer> deque, String format) {
        System.out.printf(format, deque.isEmpty() ? "none" : deque.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ")));
    }
}
