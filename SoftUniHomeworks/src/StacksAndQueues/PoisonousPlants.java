package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer> flowers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int days = 0;
        ArrayDeque<Integer> indexes = new ArrayDeque<>();

        int startFlowers = flowers.size();
        int flowersNum = 0;

        while (true) {

            for (int i = 0; i < flowers.size() - 1; i++) {
                if (flowers.get(i) < flowers.get(i + 1)) {
                    indexes.push(i + 1);
                }
            }

            while (!indexes.isEmpty()) {
                int index = indexes.pop();
                flowers.remove(index);
                flowersNum = flowers.size();
            }

            if (startFlowers > flowersNum) {
                startFlowers = flowersNum;
            } else {
                break;
            }

            days++;

        }

        System.out.println(days);

    }
}
