package StreamsFilesDirectoriesPack;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String inputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\outputFormatted.txt";

        try (FileInputStream fileStream = new FileInputStream(inputPath);
             FileOutputStream outputStream = new FileOutputStream(outputPath)){
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    outputStream.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++) {
                        outputStream.write(digits.charAt(i));
                    }
                }
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
