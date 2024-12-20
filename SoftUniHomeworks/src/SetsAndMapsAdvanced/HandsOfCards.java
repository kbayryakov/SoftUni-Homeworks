package SetsAndMapsAdvanced;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> hands = new LinkedHashMap<>();
        Map<String, Integer> playersHands = new LinkedHashMap<>();
        String input;

        while (!"JOKER".equals(input = scanner.nextLine())) {
            String name = input.split(":\\s+")[0];
            String cardsGiven = input.split(":\\s+")[1];

            String[] cards = cardsGiven.split(",\\s+");

            if (!hands.containsKey(name)) {
                hands.put(name, new LinkedHashSet<>());
            }

            for (String card : cards) {
                hands.get(name).add(card);
            }
        }


        for (var kvp : hands.entrySet()) {
            int sum = 0;
            String power;
            char type;
            for (String card : kvp.getValue()) {
                if (card.length() > 2) {
                    power = String.valueOf(card.charAt(0)) + String.valueOf(card.charAt(1));
                    type = card.charAt(2);
                } else {
                    power = String.valueOf(card.charAt(0));
                    type = card.charAt(1);
                }
                int cardPower = 0;

                switch (power) {
                    case "2":
                        if (type == 'D') {
                            cardPower = 2 * 2;
                        } else if (type == 'H') {
                            cardPower = 2 * 3;
                        } else if (type == 'S') {
                            cardPower = 2 * 4;
                        } else if (type == 'C') {
                            cardPower = 2;
                        }
                        sum += cardPower;
                        break;
                    case "3":
                        if (type == 'D') {
                            cardPower = 3 * 2;
                        } else if (type == 'H') {
                            cardPower = 3 * 3;
                        } else if (type == 'S') {
                            cardPower = 3 * 4;
                        } else if (type == 'C') {
                            cardPower = 3;
                        }
                        sum += cardPower;
                        break;
                    case "4":
                        if (type == 'D') {
                            cardPower = 4 * 2;
                        } else if (type == 'H') {
                            cardPower = 4 * 3;
                        } else if (type == 'S') {
                            cardPower = 4 * 4;
                        } else if (type == 'C') {
                            cardPower = 4;
                        }
                        sum += cardPower;
                        break;
                    case "5":
                        if (type == 'D') {
                            cardPower = 5 * 2;
                        } else if (type == 'H') {
                            cardPower = 5 * 3;
                        } else if (type == 'S') {
                            cardPower = 5 * 4;
                        } else if (type == 'C') {
                            cardPower = 5;
                        }
                        sum += cardPower;
                        break;
                    case "6":
                        if (type == 'D') {
                            cardPower = 6 * 2;
                        } else if (type == 'H') {
                            cardPower = 6 * 3;
                        } else if (type == 'S') {
                            cardPower = 6 * 4;
                        } else if (type == 'C') {
                            cardPower = 6;
                        }
                        sum += cardPower;
                        break;
                    case "7":
                        if (type == 'D') {
                            cardPower = 7 * 2;
                        } else if (type == 'H') {
                            cardPower = 7 * 3;
                        } else if (type == 'S') {
                            cardPower = 7 * 4;
                        } else if (type == 'C') {
                            cardPower = 7;
                        }
                        sum += cardPower;
                        break;
                    case "8":
                        if (type == 'D') {
                            cardPower = 8 * 2;
                        } else if (type == 'H') {
                            cardPower = 8 * 3;
                        } else if (type == 'S') {
                            cardPower = 8 * 4;
                        } else if (type == 'C') {
                            cardPower = 8;
                        }
                        sum += cardPower;
                        break;
                    case "9":
                        if (type == 'D') {
                            cardPower = 9 * 2;
                        } else if (type == 'H') {
                            cardPower = 9 * 3;
                        } else if (type == 'S') {
                            cardPower = 9 * 4;
                        } else if (type == 'C') {
                            cardPower = 9;
                        }
                        sum += cardPower;
                        break;
                    case "10":
                        if (type == 'D') {
                            cardPower = 10 * 2;
                        } else if (type == 'H') {
                            cardPower = 10 * 3;
                        } else if (type == 'S') {
                            cardPower = 10 * 4;
                        } else if (type == 'C') {
                            cardPower = 10;
                        }
                        sum += cardPower;
                        break;
                    case "J":
                        if (type == 'D') {
                            cardPower = 11 * 2;
                        } else if (type == 'H') {
                            cardPower = 11 * 3;
                        } else if (type == 'S') {
                            cardPower = 11 * 4;
                        } else if (type == 'C') {
                            cardPower = 11;
                        }
                        sum += cardPower;
                        break;
                    case "Q":
                        if (type == 'D') {
                            cardPower = 12 * 2;
                        } else if (type == 'H') {
                            cardPower = 12 * 3;
                        } else if (type == 'S') {
                            cardPower = 12 * 4;
                        } else if (type == 'C') {
                            cardPower = 12;
                        }
                        sum += cardPower;
                        break;
                    case "K":
                        if (type == 'D') {
                            cardPower = 13 * 2;
                        } else if (type == 'H') {
                            cardPower = 13 * 3;
                        } else if (type == 'S') {
                            cardPower = 13 * 4;
                        } else if (type == 'C') {
                            cardPower = 13;
                        }
                        sum += cardPower;
                        break;
                    case "A":
                        if (type == 'D') {
                            cardPower = 14 * 2;
                        } else if (type == 'H') {
                            cardPower = 14 * 3;
                        } else if (type == 'S') {
                            cardPower = 14 * 4;
                        } else if (type == 'C') {
                            cardPower = 14;
                        }
                        sum += cardPower;
                        break;
                }
            }
            playersHands.put(kvp.getKey(), sum);

        }

        for (var kvp : playersHands.entrySet()) {
            System.out.printf("%s: %d\n", kvp.getKey(), kvp.getValue());
        }

    }
}
