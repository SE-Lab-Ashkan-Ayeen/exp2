package services;

import models.Customer;

class EmailSender implements MessageSender{
    public void send(Customer customer, String message){
        System.out.println("Sending email to " + customer.email + ": " + message);
    }
}
