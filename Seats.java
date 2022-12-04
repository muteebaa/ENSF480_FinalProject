public class Seats {
    private int available;

    Seats(int n){
        available = n;
    }

    public void decrease(int n){
        available = available- n;
    }

    public void increase(int n){
        available = available+ n;
    }

    public int getSeats(){
        return available;
    }
}
