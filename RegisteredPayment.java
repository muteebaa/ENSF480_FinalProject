import java.util.Scanner;

public class RegisteredPayment implements Payment {
    
    @Override
    public void makePayment(String seatsToBook, Movie obj){
        String[] seatsArray = seatsToBook.split("\n");
        
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

    public void annualFee(){
        System.out.println("$20 annual fee paid");
    }
}
