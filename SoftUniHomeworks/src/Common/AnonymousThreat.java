import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

public class AnonymousThreat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("3:1")) {
            if (command.contains("merge")) {
                int start = Integer.parseInt(command.split(" ")[1]);
                int end = Integer.parseInt(command.split(" ")[2]);

                if (start < 0) {
                    start =0;
                } else if (start >= data.size()) {
                    start = data.size() - 1;
                }
                if (end < 0) {
                    end = 0;
                } else if (end >= data.size()) {
                    end = data.size() - 1;
                }

                StringBuilder concatenated = new StringBuilder();

                for (int i = start; i <= end; i++) {
                    concatenated.append(data.get(i));
                }
                data.set(start, String.valueOf(concatenated));
                for (int i = end; i > start; i--) {
                    data.remove(i);
                }
            } else if (command.contains("divide")) {
                int index = Integer.parseInt(command.split(" ")[1]);
                int parts = Integer.parseInt(command.split(" ")[2]);

                if (index < 0) {
                    index = 0;
                }
                if (index >= data.size()) {
                    index = data.size() - 1;
                }
                if (parts == 0) {
                    parts = 1;
                }

                String textForDivide = data.get(index);
                data.remove(index);
                int symbolsPerPart = textForDivide.length() / parts;

                int beginIndex = 0;
                for (int i = 1; i < parts; i++) {
                    String textPerPart = textForDivide.substring(beginIndex, beginIndex + symbolsPerPart);
                    data.add(index, textPerPart);
                    index++;
                    beginIndex += symbolsPerPart;
                }
                String lastPart = textForDivide.substring(beginIndex, textForDivide.length());
                data.add(index, lastPart);
            }
            command = scanner.nextLine();
        }

        System.out.println(String.join(" ", data));

    }
}
