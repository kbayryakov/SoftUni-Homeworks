package WildFarm;

import java.text.DecimalFormat;

public class Cat extends Felime {

    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.breed = breed;
    }


    @Override
    protected void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    protected void eat(Food food) {
        this.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        String template = "%s[%s, %s, %s, %s, %s]";
        return String.format(template,
                this.getAnimalType(),
                this.getAnimalName(),
                this.breed,
                decimalFormat.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
