package design.lld.cabbooking.strategy.pricecalculation;

import design.lld.cabbooking.entity.enums.PricingType;

import java.util.HashMap;
import java.util.Map;

public class PriceCalculationStrategyFactory {
    private static final Map<PricingType, PriceCalculationStrategy> strategies = new HashMap<>();

    static {
        strategies.put(PricingType.DEFAULT, new DefaultPricingStrategy());
        strategies.put(PricingType.NIGHT_SURGE, new NightSurgePricingStretegy());
    }

    public static PriceCalculationStrategy getStrategy(PricingType pricingType){
        return strategies.get(pricingType);
    }
}
