public class Guest {
    protected Payment p;
   // private int movieCredit;

    Guest(Payment type){
        p = type;

    }

    void makePayment(String seatsToBook, Movie obj){
        p.makePayment(seatsToBook, obj);
    }

    void cancelPayment(int numberOfTickets, Movie obj){
        p.cancelPayment(numberOfTickets, obj);
    }


}