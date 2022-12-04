public class Movie {
 
    private String name;
    private String time;
    private Ticket[] tickets;
    private Seats seats;
    private String theatre;
    private String date;
    private int id;
    
    Movie(String id, String nam, String tim, String d, String n, String th){
        this.id = Integer.parseInt(id);
        name = nam;
        time = tim;
        tickets = new Ticket[Integer.parseInt(n)];
        for (int i = 0; i < Integer.parseInt(n); i ++){
            //tickets[i] = new Ticket(1);
        }
        seats = new Seats(Integer.parseInt(n));
        theatre = th;
        date = d;
    }

    public String getName(){
        return name;
    }
    
    public String details(){
        String details = "\nid: "+ id +" showing at "+theatre;
        details +="\ndate: " + date;
        details +="\ntime: " + time;
        details +="\n";
        return details;
    }


    public void decreaseSeats(int n){
        seats.decrease(n);
    }

    public void increaseSeats(int n){
        seats.increase(n);
    }

    public int getSeats(){
        return seats.getSeats();
    }
    
    
}
