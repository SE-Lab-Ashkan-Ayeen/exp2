package services.payments;

public class CardPaymentHandler implements PaymentHandler{
    @Override
    public void pay(double amount) {
        System.out.println("Paid by card: " + amount);
    }
}

