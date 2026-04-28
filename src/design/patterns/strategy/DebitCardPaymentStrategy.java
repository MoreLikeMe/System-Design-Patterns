package design.patterns.strategy;

public class DebitCardPaymentStrategy implements PaymentStrategy{
    @Override
    public void proceed() {
        System.out.println("Debit Card Payment...");
    }
}
