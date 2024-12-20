package ExamPrepPart2;

import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String stops = scanner.nextLine();
        String input = "";

        while (!"Travel".equals(input = scanner.nextLine())) {
            String[] commandLine = input.split(":");
            String command = commandLine[0];

            if (command.equals("Add Stop")) {
                int index = Integer.parseInt(commandLine[1]);
                String newStop = commandLine[2];
                if (index >= 0 && index <= stops.length()) {
                    String substring1 = stops.substring(0, index);
                    String substring2 = stops.substring(index);
                    stops = substring1.concat(newStop).concat(substring2);
                }
                System.out.println(stops);
            } else if (command.equals("Remove Stop")) {
                int startIndex = Integer.parseInt(commandLine[1]);
                int endIndex = Integer.parseInt(commandLine[2]);
                if (startIndex >= 0 && startIndex < stops.length() && endIndex >= 0 && endIndex < stops.length()) {
                    String substring1 = stops.substring(0, startIndex);
                    String substring2 = stops.substring(endIndex + 1);
                    stops = substring1.concat(substring2);
                }
                System.out.println(stops);
            } else if (command.equals("Switch")) {
                String oldS = commandLine[1];
                String newS = commandLine[2];
                if (stops.contains(oldS)) {
                    stops = stops.replace(oldS, newS);
                    System.out.println(stops);
                } else {
                    System.out.println(stops);
                }
            }
        }

        System.out.printf("Ready for world tour! Planned stops: %s",stops);

    }
}