public class Movie {
 
    private String name;
    private String time;
    private Ticket[] tickets;
    private Seats seats;
    private String theatre;
    private String date;
    private String day;
    private int id;
    
    Movie(String id, String Theatre, String Movie, String dateM, String dayM, String timeM, String seats){
        this.id = Integer.parseInt(id);
        theatre = Theatre;
        this.name = Movie;
        this.date = dateM;
        this.day = dayM;
        this.time = timeM;
        tickets = new Ticket[Integer.parseInt(seats)];
        for (int i = 0; i < Integer.parseInt(seats); i ++){
           // tickets[i] = new Ticket(1);
        }
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
        seats.decrease(n);
    }

    public void increaseSeats(String[] n){
        seats.increase(n);
    }

    public Seats getSeats(){
        return seats;
    }
    
    
}
