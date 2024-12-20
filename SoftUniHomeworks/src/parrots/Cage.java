package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private String name;
    private int capacity;

    private List<Parrot> data = new ArrayList<>();

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (capacity > this.data.size()) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                data.remove(parrot);
                return true;
            }
        }
        return false;
    }

    public Parrot sellParrot(String name) {
        for (Parrot parrot : data) {
            if (parrot.getName().equals(name)) {
                parrot.setAvailable(false);
                return parrot;
            }
        }
        return null;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> soldParrots = new ArrayList<>();
        for (Parrot parrot : data) {
            if (parrot.getSpecies().equals(species)) {
                parrot.setAvailable(false);
                soldParrots.add(parrot);
            }
        }
        return soldParrots;
    }

    public int count() {
        return data.size();
    }

    public String report() {
        String format = "Parrots available at %s:%n%s";
        String availableParrots = data.stream().filter(Parrot::isAvailable)
                .map(Parrot::toString)
                .collect(Collectors.joining(System.lineSeparator()));

        return String.format(format, name, availableParrots);
    }
}
