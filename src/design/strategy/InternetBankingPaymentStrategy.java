package design.strategy;

public class InternetBankingPaymentStrategy implements PaymentStrategy{
    @Override
    public void proceed() {
        System.out.println("Internet Banking Payment...");
    }
}
