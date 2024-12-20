package StreamsFilesDirectoriesPack;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayDeque;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        File root = new File("C:\\Users\\bayryakovk\\IdeaProjects\\untitled\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        System.out.println(root.getName());

        int folderCount = 1;
        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                    folderCount++;
                    System.out.println(nestedFile.getName());
                }
            }
        }
        System.out.println(folderCount + " folders");
    }
}
