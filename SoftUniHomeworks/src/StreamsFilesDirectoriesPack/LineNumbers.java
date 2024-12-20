package StreamsFilesDirectoriesPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineNumbers {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String inputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        String outputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter printWriter = new PrintWriter(outputPath)) {
            String line = reader.readLine();
            int lineCounter = 1;

            while (line != null) {
                printWriter.write(lineCounter + ". " + line + System.lineSeparator());
                lineCounter++;
                line = reader.readLine();
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
