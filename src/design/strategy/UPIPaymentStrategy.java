package design.strategy;

public class UPIPaymentStrategy implements PaymentStrategy{
    @Override
    public void proceed() {
        System.out.println("UPI Payment...");
    }
}
