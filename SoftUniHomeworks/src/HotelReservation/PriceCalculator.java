package HotelReservation;

public class PriceCalculator {

    public static double calculatePrice (int daysNumber, double pricePerDay, Season season, Discount discount) {
        double priceWithoutDiscount = daysNumber * pricePerDay * season.getPriceMultiplier();
        double discountPrice =  (daysNumber * pricePerDay * season.getPriceMultiplier()) * discount.getPercent();
        return priceWithoutDiscount - discountPrice;
    }

}
