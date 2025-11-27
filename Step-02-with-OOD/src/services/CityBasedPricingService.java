package services;

public class CityBasedPricingService implements PricingService{

    private static final String DISCOUNTED_CITY = "Paris";
    private static final double DISCOUNT_RATE = 0.9;

    @Override
    public double calculateTotal(Reservation reservation) {
        double total = reservation.totalPrice();
        if (reservation.customer.city.equalsIgnoreCase(DISCOUNTED_CITY)) {
            return total * DISCOUNT_RATE;
        }
        return total;
    }
}

