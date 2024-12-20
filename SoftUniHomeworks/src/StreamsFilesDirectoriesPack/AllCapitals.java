package StreamsFilesDirectoriesPack;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllCapitals {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String inputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter printWriter = new PrintWriter(outputPath)) {
            String line = reader.readLine();

            while (line != null) {
                for (char symbol : line.toCharArray()) {
                    if (Character.isLetter(symbol)) {
                        printWriter.write(String.valueOf(symbol).toUpperCase());
                    } else {
                        printWriter.write(symbol);
                    }
                }
                printWriter.write(System.lineSeparator());
                line = reader.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
