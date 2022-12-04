public class Guest {
    protected Payment p;
    private int movieCredit;

    Guest(Payment type){
        p = type;

    }

    void makePayment(int numberOfTickets, Movie obj){
        p.makePayment(numberOfTickets, obj);
    }

    void cancelPayment(int numberOfTickets, Movie obj){
        p.cancelPayment(numberOfTickets, obj);
    }


}