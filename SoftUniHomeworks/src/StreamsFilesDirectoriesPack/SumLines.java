package StreamsFilesDirectoriesPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String inputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))) {
            String line = reader.readLine();

            while (line != null) {
                long sum = 0;
                for (char element : line.toCharArray()) {
                    sum += element;
                }
                System.out.println(sum);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
