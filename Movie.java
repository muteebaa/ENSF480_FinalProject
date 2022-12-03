public class Movie {
 
    private String name;
    private String time;
    private Ticket[] tickets;
    private Seats seats;

    Movie(String nam, String tim, String n){
        name = nam;
        time = tim;
        tickets = new Ticket[Integer.parseInt(n)];
        for (int i = 0; i < Integer.parseInt(n); i ++){
            tickets[i] = new Ticket(1);
        }
        seats = new Seats(Integer.parseInt(n));

    }

    public String getName(){
        return name;
    }
}
