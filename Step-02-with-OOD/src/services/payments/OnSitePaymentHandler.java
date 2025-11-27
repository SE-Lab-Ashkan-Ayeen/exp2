package services.payments;

public class OnSitePaymentHandler implements PaymentHandler{
    @Override
    public void pay(double amount) {
        System.out.println("Paid on site: " + amount);
    }
}

