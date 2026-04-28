package design.patterns.strategy;

public class PaymentServiceImpl implements PaymentService {

    private final PaymentStrategy paymentStrategy;

    public PaymentServiceImpl(PaymentStrategy paymentStrategy){
        this.paymentStrategy = paymentStrategy;
    }

    @Override
    public void makePayment() {
        paymentStrategy.proceed();
    }
}
