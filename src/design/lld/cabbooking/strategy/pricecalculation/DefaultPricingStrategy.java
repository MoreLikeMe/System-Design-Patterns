package design.lld.cabbooking.strategy.pricecalculation;

import design.lld.cabbooking.entity.TripRequest;

public class DefaultPricingStrategy implements PriceCalculationStrategy{
    @Override
    public double calculatePrice(TripRequest tripRequest) {
        return 100.0;
    }
}
