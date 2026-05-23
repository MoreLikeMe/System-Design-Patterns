package design.lld.parkinglot.strategy;

import design.lld.parkinglot.entity.Ticket;

public interface FeeCalculationStrategy {
    double calculate(Ticket ticket);
}
