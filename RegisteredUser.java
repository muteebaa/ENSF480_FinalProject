public class RegisteredUser extends Guest{
    private RegisteredPayment test1;

    RegisteredUser(RegisteredPayment type) {
        super(type);
        test1 = type;
    }

    public void annualFee(){
        test1.annualFee();
    }
    
}
