package design.patterns.template;

public class Main {
    public static void main(String[] args) {
        PaymentTemplate upi = new UPIPayment();
        PaymentTemplate debitCard = new DebitCardPayment();

        upi.proceed();
        debitCard.proceed();
    }
}
