package TextProcessing;

import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] wordsForBan = scanner.nextLine().split(", ");
        String text = scanner.nextLine();

        for (String word : wordsForBan) {
            if (text.contains(word)) {
                text = text.replace(word, replaceWord(word));
            }
        }

        System.out.println(text);

    }
    public static String replaceWord (String wordToReplace){
        String replacement = "";
        for (int i = 0; i < wordToReplace.length(); i++) {
            replacement += "*";
        }
        return replacement;
    }
}


