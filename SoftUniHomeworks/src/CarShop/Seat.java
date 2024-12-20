package CarShop;

import java.io.Serializable;

public class Seat extends CarImpl implements Sellable, Serializable {

    private Double price;

    public Seat(String model, String colour, Integer hp, String countryProduced, Double price) {
        super(model, colour, hp, countryProduced);
        this.price = price;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        String format = "This is %s produced in %s and have %d tires%n%s sells for %f%n";
        return String.format(format, getModel(), countryProduced(), this.TIRES, getModel(), getPrice());
    }
}
