package SetsAndMapsAdvanced;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String invitedGuests;
        Set<String> VIP = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        while (!"PARTY".equals(invitedGuests = scanner.nextLine())) {
            if (Character.isLetter(invitedGuests.charAt(0))) {
                regular.add(invitedGuests);
            } else if (Character.isDigit(invitedGuests.charAt(0))) {
                VIP.add(invitedGuests);
            }
        }

        String comingGuests;
        while (!"END".equals(comingGuests = scanner.nextLine())) {
            VIP.remove(comingGuests);
            regular.remove(comingGuests);
        }

        System.out.println(VIP.size() + regular.size());

        for (String guest : VIP) {
            System.out.println(guest);
        }

        for (String guest : regular) {
            System.out.println(guest);
        }
    }
}
