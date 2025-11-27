package services;

import constants.PaymentMethods;
import services.payments.*;

import java.util.EnumMap;
import java.util.Map;

public class PaymentProcessor {

    private final Map<PaymentMethods, PaymentHandler> handlers;

    public PaymentProcessor(Map<PaymentMethods, PaymentHandler> handlers) {
        this.handlers = new EnumMap<>(handlers);
    }

    public void process(PaymentMethods method, double amount) {
        PaymentHandler handler = handlers.get(method);

        if (handler == null) {
            throw new IllegalArgumentException("Payment method " + method + " is not supported.");
        }

        handler.pay(amount);
    }

    public static PaymentProcessor defaultProcessor() {
        Map<PaymentMethods, PaymentHandler> defaults = new EnumMap<>(PaymentMethods.class);
        defaults.put(PaymentMethods.CARD, new CardPaymentHandler());
        defaults.put(PaymentMethods.CASH, new CashPaymentHandler());
        defaults.put(PaymentMethods.PAYPAL, new PayPalPaymentHandler());
        defaults.put(PaymentMethods.ONSITE, new OnSitePaymentHandler());
        return new PaymentProcessor(defaults);
    }
}