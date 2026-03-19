package design.strategy;

public class Main {
    public static void main(String[] args) {
        PaymentService service = new PaymentServiceImpl(new DebitCardPaymentStrategy());
        service.makePayment();
    }
}
