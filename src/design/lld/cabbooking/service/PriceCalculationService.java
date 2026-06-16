package design.lld.cabbooking.service;

import design.lld.cabbooking.entity.TripRequest;
import design.lld.cabbooking.entity.enums.PricingType;
import design.lld.cabbooking.strategy.pricecalculation.PriceCalculationStrategy;
import design.lld.cabbooking.strategy.pricecalculation.PriceCalculationStrategyFactory;

public class PriceCalculationService {
    private PriceCalculationStrategy priceCalculationStrategy;

    public double fetchEstimatedPrice(TripRequest tripRequest){
        //****based on tripRequest, pricing type will be decided, night time or not, weather****//
        PricingType pricingType = PricingType.DEFAULT;
        priceCalculationStrategy = PriceCalculationStrategyFactory.getStrategy(pricingType);
        return priceCalculationStrategy.calculatePrice(tripRequest);
    }
}
