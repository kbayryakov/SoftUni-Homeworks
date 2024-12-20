package WildFarm;

public abstract class Animal {

    private String animalType;
    private String animalName;
    private Double animalWeight;
    private int foodEaten;

    public Animal(String animalType, String animalName, Double animalWeight) {
        this.animalType = animalType;
        this.animalName = animalName;
        this.animalWeight = animalWeight;
    }

    public String getAnimalType() {
        return animalType;
    }

    public String getAnimalName() {
        return animalName;
    }

    public Double getAnimalWeight() {
        return animalWeight;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten += foodEaten;
    }

    protected abstract void makeSound();
    protected abstract void eat(Food food);
}
