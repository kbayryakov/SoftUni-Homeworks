package HotelReservation;

public enum Discount {
    VIP(0.2), SECOND_VISIT(0.1), NONE(0);

    private double percent;

    Discount(double percent) {
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }
}
