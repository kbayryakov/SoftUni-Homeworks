package CarShop;

public class CarImpl implements Car {

    private String model;
    private String colour;
    private Integer hp;
    private String countryProduced;

    public CarImpl(String model, String colour, Integer hp, String countryProduced) {
        this.model = model;
        this.colour = colour;
        this.hp = hp;
        this.countryProduced = countryProduced;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getColor() {
        return this.colour;
    }

    @Override
    public Integer getHorsePower() {
        return this.hp;
    }

    @Override
    public String countryProduced() {
        return this.countryProduced;
    }

    @Override
    public String toString() {
        String format = "This is %s produced in %s and have %d tires";
        return String.format(format, getModel(), countryProduced(), this.TIRES);
    }
}
