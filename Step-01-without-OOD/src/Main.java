import constants.PaymentMethods;
import models.Customer;
import models.LuxuryRoom;
import constants.Notifier;
import services.Reservation;
import models.Room;
import services.ReservationService;

public class Main {
    public static void main(String[] args){
        Customer customer = new Customer("Ali", "ali@example.com","09124483765", "Paris");
        Room room = new LuxuryRoom("203", 150);
        Reservation res = new Reservation(room, customer, 2);

        ReservationService service = new ReservationService();
        service.makeReservation(res, PaymentMethods.PAYPAL, Notifier.EMAIL);

        Customer onsiteCustomer = new Customer("Sara", "sara@example.com","09351234567", "Tehran");
        Room standardRoom = new Room("105", "standard", 90);
        Reservation onsiteRes = new Reservation(standardRoom, onsiteCustomer, 3);

        service.makeReservation(onsiteRes, PaymentMethods.ONSITE, Notifier.SMS);
    }
}