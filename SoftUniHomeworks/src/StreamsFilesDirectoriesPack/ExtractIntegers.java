package StreamsFilesDirectoriesPack;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String inputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileReader fileReader = new FileReader(inputPath)) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    System.out.println(scanner.nextInt());
                }
                scanner.next();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
