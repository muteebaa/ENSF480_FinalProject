import java.util.LinkedList;

public class Movie {
 
    private String name;
    private String time;
    private LinkedList<Ticket> tickets = new LinkedList<Ticket>();
    private Seats seats;
    private String theatre;
    private String date;
    private String day;
    private int id;
    private int tickNumber = 0;
    
    Movie(String id, String Theatre, String Movie, String dateM, String dayM, String timeM, String seats){
        this.id = Integer.parseInt(id);
        theatre = Theatre;
        this.name = Movie;
        this.date = dateM;
        this.day = dayM;
        this.time = timeM;
        this.seats = new Seats(Integer.parseInt(seats));
        
    }

    public String getName(){
        return name;
    }  
    
    String getDate(){
        return date;
    }

    public String getDay(){
        return day;
    }

    public String getTime(){
        return time;
    }
    
    public String details(){
        String details = "\nid: "+ id +" showing at "+theatre;
        details +="\ndate: " + date;
        details +="\ntime: " + time;
        details +="\n";
        return details;
    }


    public void decreaseSeats(String[] n){
        addTickets(n);
        seats.decrease(n);
    }

    public void increaseSeats(String n){
        seats.increase(n);
    }

    public Seats getSeats(){
        return seats;
    }

    public void addTickets(String[] n){
        for(int i = 0 ; i < n.length; i++){
            tickets.add(new Ticket(n[i]));
        }
    }

    public void removeTickets(String code){
        for(int i = 0 ; i < tickets.size(); i++){
            if(tickets.get(i).getCode() == code){
                increaseSeats(tickets.get(i).getSeat());
                tickets.remove(i);
                break;
            }
        }
    }
    
}
