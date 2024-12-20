package StreamsFilesDirectoriesPack;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class GetFolderSize {
    public static void main(String[] args) {
        File root = new File("C:\\Users\\bayryakovk\\IdeaProjects\\untitled\\Streams and Files\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources");

        Deque<File> dirs = new ArrayDeque<>();
        dirs.offer(root);
        long folderSize = 0;

        while (!dirs.isEmpty()) {
            File current = dirs.poll();
            File[] nestedFiles = current.listFiles();
            for (File nestedFile : nestedFiles) {
                if (nestedFile.isDirectory()) {
                    dirs.offer(nestedFile);
                } else {
                    folderSize += nestedFile.length();
                }
            }
        }

        System.out.println("Folder size: " + folderSize);

    }
}
