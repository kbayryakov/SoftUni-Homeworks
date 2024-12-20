package StreamsFilesDirectoriesPack;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\bayryakovk\\IdeaProjects\\untitled\\src\\StreamsFilesDirectories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try (FileInputStream fileStream = new FileInputStream(path)){
            int oneByte = fileStream.read();
            while (oneByte >= 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = fileStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
