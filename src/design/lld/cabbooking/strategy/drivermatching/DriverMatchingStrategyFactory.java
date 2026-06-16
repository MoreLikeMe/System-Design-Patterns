package design.lld.cabbooking.strategy.drivermatching;

import design.lld.cabbooking.entity.enums.DriverMatchingType;

import java.util.HashMap;
import java.util.Map;

public class DriverMatchingStrategyFactory {

    private static final Map<DriverMatchingType, DriverMatchingStrategy> strategies = new HashMap<>();

    static {
        strategies.put(DriverMatchingType.HIGHEST_RATING, new HigestRatingStrategy());
        strategies.put(DriverMatchingType.LOWEST_DISTANCE, new LowestDistanceStrategy());
        //strategies.put(DriverMatchingType.LEAST_TIME_TAKEN, new LeastTimeTakenStrategy());
    }

    public static DriverMatchingStrategy getStrategy(DriverMatchingType driverMatchingType){
        return strategies.get(driverMatchingType);
    }
}
