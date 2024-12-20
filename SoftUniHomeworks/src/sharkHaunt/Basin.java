package sharkHaunt;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Basin {
    private String name;
    private int capacity;
    private List<Shark> sharks;

    public Basin(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.sharks = new ArrayList<>();
    }

    public void addShark (Shark shark) {
        if (sharks.size() < capacity) {
            sharks.add(shark);
        } else {
            System.out.println("This basin is at full capacity!");
        }
    }

    public boolean removeShark (String kind) {
        for (Shark shark : sharks) {
            if (shark.getKind().equals(kind)) {
                sharks.remove(shark);
                return true;
            }
        }
        return false;
    }

    public Shark getLargestShark () {
        int biggest = Integer.MIN_VALUE;
        Shark biggestShark = null;
        for (Shark shark : sharks) {
            if (shark.getLength() > biggest) {
                biggest = shark.getLength();
                biggestShark = shark;
            }
        }
        return biggestShark;
    }

    public Shark getShark (String kind) {
        for (Shark shark : sharks) {
            if (shark.getKind().equals(kind)) {
                return shark;
            }
        }
        return null;
    }

    public int getCount () {
        return sharks.size();
    }

    public int getAverageLength () {
        int length = 0;
        for (Shark shark : sharks) {
            length += shark.getLength();
        }
        return length / sharks.size();
    }

    public String report () {
        String format = "Sharks in %s:%n%s";
        String availableSharks = sharks.stream().map(Shark::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        return String.format(format, name, availableSharks);
    }
}
