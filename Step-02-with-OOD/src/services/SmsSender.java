package services;

import models.Customer;

class SmsSender implements MessageSender{
    public void send(Customer customer, String message){
        System.out.println("Sending SMS to " + customer.mobile + ": " + message);
    }
}
