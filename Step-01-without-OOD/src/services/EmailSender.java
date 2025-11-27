package services;

class EmailSender implements MessageSender{
    public void sendEmail(String to, String message){
        System.out.println("Sending email to " + to + ": " + message);
    }

    public void sendSms(String phoneNumber, String message){
        System.out.println("Email sender cannot send SMS messages.");
    }
}
