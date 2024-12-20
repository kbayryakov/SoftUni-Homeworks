package CarShop;

import java.io.Serializable;

public class Audi extends CarImpl implements Rentable, Serializable {

    private Integer minRentPerDay;
    private Double pricePerDay;

    public Audi(String model, String colour, Integer hp, String countryProduced, Integer minRentPerDay, Double pricePerDay) {
        super(model, colour, hp, countryProduced);
        this.minRentPerDay = minRentPerDay;
        this.pricePerDay = pricePerDay;
    }


    @Override
    public Integer getMinRentDay() {
        return this.minRentPerDay;
    }

    @Override
    public Double getPricePerDay() {
        return this.pricePerDay;
    }

    @Override
    public String toString() {
        String format = "This is %s produced in %s and have %d tires%nMinimum rental period of %d days. Price per day %f%n";
        return String.format(format, getModel(), countryProduced(), this.TIRES, getMinRentDay(), getPricePerDay());
    }
}
