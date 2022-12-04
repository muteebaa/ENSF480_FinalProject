import java.util.LinkedList;

public class Seats {
    private int available;
    private LinkedList<String> seats= new LinkedList<String>();
    String next = "A";

    Seats(int n){
        available = n;
        for (int i = 0; i < n; i++){
            String s = "A";
            if (i!= 0 && i%5 == 0){
                System.out.println(i);
                int charValue = s.charAt(0);
                next = String.valueOf( (char) (charValue + 1));      
                System.out.println(s);
            }
            s = next;
            s += String.valueOf(i+1);
            seats.add(s);
        }
    }

    public void decrease(int n){
        available = available- n;
    }

    public void increase(int n){
        available = available+ n;
    }

    public int getAvailable(){
        return available;
    }

    public LinkedList<String> getSeats(){
        return seats;
    }
}
