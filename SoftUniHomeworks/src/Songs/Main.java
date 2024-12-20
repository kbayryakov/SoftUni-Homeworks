package Songs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Song> songs = new ArrayList<>();
        int numberOfSongs = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfSongs; i++) {
            String[] input = scanner.nextLine().split("_");

            String type = input[0];
            String name = input[1];
            String time = input[2];

            Song song = new Song();

            song.setTypeList(type);
            song.setName(name);
            song.setTime(time);

            songs.add(song);
        }

        String typeList = scanner.nextLine();
        if (typeList.equals("all")) {
            for (Song song : songs) {
                System.out.println(song.getName());
            }
        } else {
            for (Song song : songs) {
                if (typeList.equals(song.getTypeList())) {
                    System.out.println(song.getName());
                }
            }
        }
    }
}
