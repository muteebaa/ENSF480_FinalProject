public class Movie {
 
    private String name;
    private String time;
    private Ticket[] tickets;
    private Seats seats;
    private String theatre;

    Movie(String nam, String tim, String n, String th){
        name = nam;
        time = tim;
        tickets = new Ticket[Integer.parseInt(n)];
        for (int i = 0; i < Integer.parseInt(n); i ++){
            tickets[i] = new Ticket(1);
        }
        seats = new Seats(Integer.parseInt(n));
        theatre = th;
    }

    public String getName(){
        return name;
    }
    
    public void display(){
        System.out.println("showing at "+theatre);
        System.out.println("time: " + time);
        System.out.println();
    }
}
