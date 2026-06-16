package design.lld.cabbooking.strategy.pricecalculation;

import design.lld.cabbooking.entity.TripRequest;

public interface PriceCalculationStrategy {
    double calculatePrice(TripRequest tripRequest);
}
