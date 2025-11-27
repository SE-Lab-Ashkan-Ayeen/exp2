package services;

import constants.Notifier;
import models.Customer;

import java.util.EnumMap;
import java.util.Map;

public class NotificationDispatcher {

    private final Map<Notifier, MessageSender> channels;
    private final Notifier defaultNotifier;

    public NotificationDispatcher(Map<Notifier, MessageSender> channels, Notifier defaultNotifier) {
        this.channels = new EnumMap<>(channels);
        this.defaultNotifier = defaultNotifier;
    }

    public void notifyCustomer(Notifier notifier, Customer customer, String message) {
        Notifier channelKey = notifier != null ? notifier : defaultNotifier;
        MessageSender sender = channels.get(channelKey);

        if (sender == null) {
            System.out.println("There is no Message Provider");
            return;
        }

        sender.send(customer, message);
    }

    public static NotificationDispatcher defaultDispatcher() {
        Map<Notifier, MessageSender> defaults = new EnumMap<>(Notifier.class);
        defaults.put(Notifier.EMAIL, new EmailSender());
        defaults.put(Notifier.SMS, new SmsSender());
        return new NotificationDispatcher(defaults, Notifier.EMAIL);
    }
}

