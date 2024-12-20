package StreamsFilesDirectoriesPack;

import java.io.File;

public class ListFiles {
    public static void main(String[] args) {
        File f = new File("C:\\Users\\bayryakovk\\IdeaProjects\\untitled\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        if (f.isDirectory()) {
            File[] files = f.listFiles();
            for (File file : files) {
                if (file.isFile()) {
                    System.out.printf("%s: [%d]\n", file.getName(), file.length());
                }
            }
        }
    }
}
