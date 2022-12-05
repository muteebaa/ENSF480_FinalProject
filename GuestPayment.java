import java.util.Scanner;

public class GuestPayment implements Payment {

    @Override
    public void makePayment(String seatsToBook, Movie obj){
        // prompt user to pay
        
        String[] seatsArray = seatsToBook.split(" ");
        
        
        for (String e : seatsArray){
            System.out.println(e);
        }

        obj.decreaseSeats(seatsArray);
     /*   for (all in seats){
        create ticket
        get ticket
        email ticket
        }*/


    }

    @Override
    public void cancelPayment(String cancelCode, Movie obj) {
        obj.removeTickets(cancelCode);
    }

}