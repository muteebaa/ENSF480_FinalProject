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
    public void cancelPayment(String seatsToCancel, Movie obj) {
        System.out.println("tickets have been cancelled.");
        System.out.println("There was a 15% administration fee");
        System.out.print(" and you have received $");

        String[] seatsArray = seatsToCancel.split(" ");
        
        
        for (String e : seatsArray){
            System.out.println(e);
        }

        obj.increaseSeats(seatsArray);
    }

}