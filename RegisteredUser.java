public class RegisteredUser extends Guest{
    private RegisteredPayment test1;
    private String email;
    private String password;
    private String ccInfo;

    RegisteredUser(RegisteredPayment type, String email, String password, String ccInfo ) {
        
        super(type);
        test1 = type;
        this.email = email;
        this.password = password;
        this.ccInfo = ccInfo;
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

    public String getCCInfo(){
        return ccInfo;
    }

}
