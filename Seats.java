import java.util.LinkedList;

public class Seats {
    private int available;
    private LinkedList<String> seats;

    Seats(int n){
        available = n;
        for (int i = 0; i < n; i++){
            String s = "A";
            if (i!= 0 && i%5 == 0){
                int charValue = s.charAt(0);
                String next = String.valueOf( (char) (charValue + 1));
                s = next;
            }
            s += String.valueOf(i);
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
