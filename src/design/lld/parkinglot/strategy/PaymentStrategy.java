package design.lld.parkinglot.strategy;

import design.lld.parkinglot.entity.Ticket;

public interface PaymentStrategy {
    boolean makePayment(Ticket ticket, double fee);
}
