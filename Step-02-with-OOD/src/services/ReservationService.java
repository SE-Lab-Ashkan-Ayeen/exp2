package services;

import constants.Notifier;
import constants.PaymentMethods;

public class ReservationService {

    private final PaymentProcessor paymentProcessor;
    private final NotificationDispatcher notificationDispatcher;
    private final PricingService pricingService;

    public ReservationService(PaymentProcessor paymentProcessor,
                              NotificationDispatcher notificationDispatcher,
                              PricingService pricingService) {
        this.paymentProcessor = paymentProcessor;
        this.notificationDispatcher = notificationDispatcher;
        this.pricingService = pricingService;
    }

    public void makeReservation(Reservation res, PaymentMethods paymentType, Notifier notifier) {
        System.out.println("Processing reservation for " + res.customer.name);

        double finalPrice = pricingService.calculateTotal(res);
        paymentProcessor.process(paymentType, finalPrice);

        System.out.println("----- INVOICE -----");
        System.out.println("hotel.Customer: " + res.customer.name);
        System.out.println("hotel.Room: " + res.room.number + " (" + res.room.type + ")");
        System.out.println("Total: " + finalPrice);
        System.out.println("-------------------");

        notificationDispatcher.notifyCustomer(notifier, res.customer, "Your reservation confirmed!");
    }
}