import java.util.Scanner;

public class GuestPayment implements Payment {

    @Override
    public void makePayment(int n, Movie obj) {
        // prompt user to pay
        Scanner c = new Scanner(System.in);
        System.out.println("Please enter your card number");
        String card = c.nextLine();
        
        
        Scanner e = new Scanner(System.in);
        System.out.println("Please enter your email address");
        String email = e.nextLine();
        int x = 0;

        obj.decreaseSeats(n);
        
     /*   for (all in seats){
        create ticket
        get ticket
        email ticket
        }*/


    }

    @Override
    public void cancelPayment(int numberOfTickets, Movie obj) {
        System.out.println("tickets have been cancelled.");
        System.out.println("There was a 15% administration fee");
        System.out.print(" and you have received $");

        obj.increaseSeats(numberOfTickets);
    }
}