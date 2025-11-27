package services;

class SmsSender implements MessageSender{
    public void sendEmail(String to, String message){
        System.out.println("SMS sender cannot send emails.");
    }

    public void sendSms(String phoneNumber, String message){
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}

