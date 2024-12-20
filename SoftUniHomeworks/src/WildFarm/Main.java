package WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input;
        Animal animal;
        List<Animal> animals = new ArrayList<>();

        while (!"End".equals(input = scanner.nextLine())) {
            String[] animalInfo = input.split("\\s+");
            String[] foodInfo = scanner.nextLine().split("\\s+");

            animal = animalFactory(animalInfo);
            Food food = foodFactory(foodInfo);
            animal.makeSound();
            animal.eat(food);
            animals.add(animal);
        }

        for (Animal a : animals) {
            System.out.println(a);
        }
    }

    private static Food foodFactory(String[] elements) {
        Food food = null;

        String foodType = elements[0];
        Integer quantity = Integer.parseInt(elements[1]);

        switch (foodType) {
            case "Vegetable":
                food = new Vegetable(quantity);
                break;
            case "Meat":
                food = new Meat(quantity);
                break;
        }
        return food;
    }

    private static Animal animalFactory(String[] elements) {
        Animal animal = null;
        String animalType = elements[0];
        String animalName = elements[1];
        Double animalWeight = Double.parseDouble(elements[2]);
        String livingRegion = elements[3];

        switch (animalType) {
            case "Cat":
                String breed = elements[4];
                animal = new Cat(animalType, animalName, animalWeight, livingRegion, breed);
                break;
            case "Tiger":
                animal = new Tiger(animalType, animalName, animalWeight, livingRegion);
                break;
            case "Mouse":
                animal = new Mouse(animalType, animalName, animalWeight, livingRegion);
                break;
            case "Zebra":
                animal = new Zebra(animalType, animalName, animalWeight, livingRegion);
                break;
        }
        return animal;
    }
}
