package StreamsFilesDirectoriesPack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String inputWordsPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String inputTextPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        String outputPath = root + "\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        Map<String, Integer> wordsCount = new HashMap<>();

        try (BufferedReader reader1 = Files.newBufferedReader(Paths.get(inputWordsPath));
             BufferedReader reader2 = Files.newBufferedReader(Paths.get(inputTextPath));
             PrintWriter printWriter = new PrintWriter(outputPath)) {
            String lineFromWords = reader1.readLine();
            while (lineFromWords != null) {
                for (String word : Arrays.stream(lineFromWords.split("\\s+")).toList()) {
                    wordsCount.put(word, 0);
                }
                lineFromWords = reader1.readLine();
            }

            String lineFromText = reader2.readLine();
            while (lineFromText != null) {
                for (String word : Arrays.stream(lineFromText.split("\\s+")).toList()) {
                    if (wordsCount.containsKey(word)) {
                        wordsCount.put(word, wordsCount.get(word) + 1);
                    }
                }
                lineFromText = reader2.readLine();
            }

            LinkedHashMap<String, Integer> sorted = wordsCount.entrySet()
                    .stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(LinkedHashMap::new, (map, entry) -> map.put(entry.getKey(), entry.getValue()), LinkedHashMap::putAll);

            for (var kvp : sorted.entrySet()) {
                printWriter.write(kvp.getKey() + " - " + kvp.getValue() + System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}
