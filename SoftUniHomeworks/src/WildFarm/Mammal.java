package WildFarm;

import java.text.DecimalFormat;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    protected abstract void makeSound();

    @Override
    protected abstract void eat(Food food);

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String template = "%s[%s, %s, %s, %s]";
        return String.format(template,
                this.getAnimalType(),
                this.getAnimalName(),
                decimalFormat.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
