package WildFarm;

public abstract class Felime extends Mammal{


    public Felime(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    protected abstract void makeSound();

    @Override
    protected abstract void eat(Food food);

}
