import java.nio.charset.Charset;
import java.util.Random;
import java.lang.Math.*;

public class Ticket {
    private String code;
    private String seat;

    Ticket(String s){
        //new String(array, Charset.forName("UTF-8"));
        seat = s;
        createCode();
    }

    public void createCode(){
        String letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        StringBuilder s = new StringBuilder(5);
        for (int i =0; i<5;i++){
            int letter = (int)(letters.length()* Math.random());

            s.append(letters.charAt(letter));
        }
        code = s.toString();
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
