import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> lessons = Arrays
                .stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String command = scanner.nextLine();

        while (!command.equals("course start")) {
            if (command.contains("Add")) {
                String lesson = command.split(":")[1];
                if (!lessons.contains(lesson)) {
                    lessons.add(lesson);
                }
            } else if (command.contains("Insert")) {
                String lesson = command.split(":")[1];
                int index = Integer.parseInt(command.split(":")[2]);
                if (!lessons.contains(lesson)) {
                    lessons.add(index, lesson);
                }
            } else if (command.contains("Remove")) {
                String lesson = command.split(":")[1];
                lessons.remove(lesson);
                lessons.remove(lesson + "-Exercise");
            } else if (command.contains("Swap")) {
                String lesson1 = command.split(":")[1];
                String lesson2 = command.split(":")[2];
                if (lessons.contains(lesson1) && lessons.contains(lesson2)) {
                    int index1 = lessons.indexOf(lesson1);
                    int index2 = lessons.indexOf(lesson2);
                    lessons.set(index1, lesson2);
                    lessons.set(index2, lesson1);
                }
                if (lessons.contains(lesson1 + "-Exercise")) {
                    lessons.remove(lesson1 + "-Exercise");
                    int indexOfLesson = lessons.indexOf(lesson1);
                    lessons.add(indexOfLesson + 1, lesson1 + "-Exercise");
                }
                if (lessons.contains(lesson2 + "-Exercise")) {
                    lessons.remove(lesson2 + "-Exercise");
                    int indexOfLesson = lessons.indexOf(lesson2);
                    lessons.add(indexOfLesson + 1, lesson2 + "-Exercise");
                }
            } else if (command.contains("Exercise")) {
                String lesson = command.split(":")[1];
                if (lessons.contains(lesson) && !lessons.contains(lesson + "-Exercise")) {
                    int index = lessons.indexOf(lesson);
                    lessons.add(index + 1, lesson + "-Exercise");
                }
                if (!lessons.contains(lesson)) {
                    lessons.add(lesson);
                    lessons.add(lesson + "-Exercise");
                }
            }
            command = scanner.nextLine();
        }

        for (int i = 0; i < lessons.size() ; i++) {
            System.out.printf("%d.%s%n", i + 1, lessons.get(i));
        }

    }
}
