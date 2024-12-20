package ExamPrep;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class ChickenSnack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> moneyStack = new ArrayDeque<>();
        Deque<Integer> priceQueue = new ArrayDeque<>();
        int foodsEaten = 0;

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(moneyStack::push);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .forEach(priceQueue::offer);

        while (!moneyStack.isEmpty() && !priceQueue.isEmpty()) {
            int money = moneyStack.peek();
            int price = priceQueue.peek();
            int change;

            if (money > price) {
                moneyStack.pop();
                priceQueue.poll();
                change = money - price;
                if (!moneyStack.isEmpty()) {
                    int newValue = moneyStack.pop() + change;
                    moneyStack.push(newValue);
                }
                foodsEaten++;
            } else if (money == price) {
                moneyStack.pop();
                priceQueue.poll();
                foodsEaten++;
            } else {
                moneyStack.pop();
                priceQueue.poll();
            }
        }

        if (foodsEaten == 0) {
            System.out.println("Henry remained hungry. He will try next weekend again.");
        } else if (foodsEaten < 4) {
            if (foodsEaten == 1) {
                System.out.printf("Henry ate: %d food.\n", foodsEaten);
            } else {
                System.out.printf("Henry ate: %d foods.\n", foodsEaten);
            }
        } else {
            System.out.printf("Gluttony of the day! Henry ate %d foods.\n", foodsEaten);
        }
    }
}
