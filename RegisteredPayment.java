import java.util.Scanner;

public class RegisteredPayment implements Payment {
    

    @Override
    public  void makePayment(String seatsToBook, Movie obj) {
        // prompt user to pay
        Scanner c = new Scanner(System.in);
        System.out.println("we have ur card number");
        String card = c.nextLine();
        
        
        Scanner e = new Scanner(System.in);
        System.out.println("we have your email address");
        String email = e.nextLine();
        int x = 0;

     //   obj.decreaseSeats(numberOfTickets);
    }
    
    @Override
    public void cancelPayment(int numberOfTickets, Movie obj) {
        System.out.println("tickets have been cancelled.");
        System.out.println("You have been fully refunded");

        obj.increaseSeats(numberOfTickets);
    }

    public void annualFee(){
        System.out.println("$20 annual fee paid");
    }
}
