package StreamsFilesDirectoriesPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String inputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";

        Character[] letters = {'a', 'e', 'i', 'o', 'u'};
        Character[] symbols = {'!', '?', '.', ','};
        Set<Character> vowels = new HashSet<>();
        Set<Character> punct = new HashSet<>();
        Collections.addAll(vowels, letters);
        Collections.addAll(punct, symbols);

        int vowelsSum = 0;
        int puctSum = 0;
        int othersSum = 0;


        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter printWriter = new PrintWriter(outputPath)) {
            String line = reader.readLine();

            while (line != null) {
                for (char symbol : line.toCharArray()) {
                    if (vowels.contains(symbol)) {
                        vowelsSum++;
                    } else if (punct.contains(symbol)) {
                        puctSum++;
                    } else if (!Character.isWhitespace(symbol)) {
                        othersSum++;
                    }
                }
                line = reader.readLine();
            }
            printWriter.write("Vowels: " + vowelsSum + System.lineSeparator());
            printWriter.write("Other symbols: " + othersSum + System.lineSeparator());
            printWriter.write("Punctuation: " + puctSum);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
