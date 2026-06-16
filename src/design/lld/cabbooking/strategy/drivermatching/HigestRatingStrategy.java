package design.lld.cabbooking.strategy.drivermatching;

import design.lld.cabbooking.entity.TripRequest;
import design.lld.cabbooking.entity.Driver;

import java.util.Set;

public class HigestRatingStrategy implements DriverMatchingStrategy{

    @Override
    public Driver matchDriver(Set<Driver> drivers, TripRequest tripRequest) {
        return null;
    }
}
