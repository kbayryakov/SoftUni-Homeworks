package SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String command;

        while (!"Revision".equals(command = scanner.nextLine())) {
            String shop = command.split(",\\s+")[0];
            String product = command.split(",\\s+")[1];
            double price = Double.parseDouble(command.split(",\\s+")[2]);

            if (!shops.containsKey(shop)) {
                shops.put(shop, new LinkedHashMap<>());
            }

            shops.get(shop).put(product, price);
        }

        for (var kvp : shops.entrySet()) {
            System.out.printf("%s->\n", kvp.getKey());
            for (var kvp2 : kvp.getValue().entrySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", kvp2.getKey(), kvp2.getValue());
            }
        }
    }
}
