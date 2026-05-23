package design.lld.parkinglot.service;

import design.lld.parkinglot.entity.Ticket;
import design.lld.parkinglot.strategy.FeeCalculationStrategy;
import design.lld.parkinglot.strategy.PaymentStrategy;

/**
 *
 * Payment Service has not been main focus in this LLD
 * Payment service will be implemented fully using strategies
 * in some other LLD
 */
public class PaymentService {

    private FeeCalculationStrategy calculation;
    private PaymentStrategy payment;

    //*************Implementation Pending
    public double calculatePayment(Ticket ticket){
        return 0.0;
    }

    //*************Implementation Pending
    public boolean makePayment(Ticket ticket){
        return true;
    }
}
