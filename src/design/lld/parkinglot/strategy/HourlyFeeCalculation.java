package design.lld.parkinglot.strategy;

import design.lld.parkinglot.entity.Ticket;

public class HourlyFeeCalculation implements FeeCalculationStrategy{

    //*************Implementation Pending
    @Override
    public double calculate(Ticket ticket) {
        return 100.0;
    }
}
