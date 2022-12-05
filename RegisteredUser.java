public class RegisteredUser extends Guest{
    private RegisteredPayment test1;
    private String email;
    private String password;
    private String cardNumber;
    private String cvv;
    private String expiry;
    private Boolean feePaid;

    RegisteredUser(RegisteredPayment type, String email, String password, String cardNumber, String cvv, String expiry, Boolean feePaid ) {
        
        super(type);
        test1 = type;
        this.email = email;
        this.password = password;
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiry = expiry;
        this.feePaid = feePaid;
    }


    public void annualFee(){
        test1.annualFee();
    }

    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }

    public String getCardNumber(){
        return cardNumber;
    }

    public String getCVV(){
        return cvv;
    }

    public String getExpiry(){
        return expiry;
    }

    public Boolean getFeePaid(){
        return feePaid;
    }

}
