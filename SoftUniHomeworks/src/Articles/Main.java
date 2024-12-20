package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int n = Integer.parseInt(scanner.nextLine());

        Article article = new Article();
        article.setTitle(input[0]);
        article.setContent(input[1]);
        article.setAuthor(input[2]);

        for (int i = 1; i <= n; i++) {
            String command = scanner.nextLine();

            if (command.contains("Edit")){
                String newContent = command.split(": ")[1];
                article.setContent(newContent);
            } else if (command.contains("ChangeAuthor")) {
                String newAuthor = command.split(": ")[1];
                article.setAuthor(newAuthor);
            } else if (command.contains("Rename")) {
                String newTitle = command.split(": ")[1];
                article.setTitle(newTitle);
            }
        }

        System.out.printf("%s - %s: %s", article.getTitle(), article.getContent(), article.getAuthor());

    }
}
