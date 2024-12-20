package aquarium;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Aquarium {
    private String name;
    private int capacity;
    private int size;
    private Set<Fish> fishInPool;

    public String getName() {
        return this.name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public int getSize() {
        return this.size;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    private boolean containsFish(Fish f) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(f.getName())) {
                return true;
            }
        }
        return false;
    }
    private boolean checkSpace() {
        return this.capacity > fishInPool.size();
    }

    public void add(Fish fish) {
        if (!containsFish(fish) && checkSpace()) {
            fishInPool.add(fish);
        }
    }

    public boolean remove(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                fishInPool.remove(fish);
                this.size--;
                return true;
            }
        }
        return false;
    }

    public String findFish(String name) {
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)) {
                return fish.getName();
            }
        }
        return null;
    }

    public String report() {
        String format = "Aquarium: %s ^ Size: %d%n%s";
        String allFish = this.fishInPool.stream()
                .map(Fish::toString)
                .collect(Collectors.joining(System.lineSeparator()));
        return String.format(format, this.getName(), this.getSize(), allFish);
    }

    public Aquarium(String name, int capacity, int size) {
        this.name = name;
        this.capacity = capacity;
        this.size = size;
        this.fishInPool = new LinkedHashSet<>();
    }
}
