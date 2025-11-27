package services.payments;

public class PayPalPaymentHandler implements PaymentHandler{
    @Override
    public void pay(double amount) {
        System.out.println("Paid by PayPal: " + amount);
    }
}

