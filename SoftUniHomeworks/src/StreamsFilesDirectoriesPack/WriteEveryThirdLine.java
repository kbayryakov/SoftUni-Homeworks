package StreamsFilesDirectoriesPack;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String root = System.getProperty("user.dir");
        String inputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputFormatted.txt";

        List<String> inputData = Files.readAllLines(Paths.get(inputPath));

        for (int i = 0; i < inputData.size(); i++) {
            if ((i + 1) % 3 == 0) {
                Files.writeString(Paths.get(outputPath), inputData.get(i) + System.lineSeparator(),
                        StandardOpenOption.APPEND);
            }
        }
        
    }
}
