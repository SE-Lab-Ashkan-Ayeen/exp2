package services.payments;

public class CashPaymentHandler implements PaymentHandler{
    @Override
    public void pay(double amount) {
        System.out.println("Paid by cash: " + amount);
    }
}

