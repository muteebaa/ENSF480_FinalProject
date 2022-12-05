import java.nio.charset.Charset;
import java.util.Random;

public class Ticket {
    private String code;
    private String seat;

    Ticket(String s){
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        code = "random";
        //new String(array, Charset.forName("UTF-8"));
        seat = s;
    }

    public String getCode(){
        return code;
    }

    public String getSeat(){
        return seat;
    }

    /*emailTicket(){

    }*/

    
}
