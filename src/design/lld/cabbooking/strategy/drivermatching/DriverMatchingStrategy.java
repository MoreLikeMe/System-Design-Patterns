package design.lld.cabbooking.strategy.drivermatching;

import design.lld.cabbooking.entity.TripRequest;
import design.lld.cabbooking.entity.Driver;

import java.util.Set;

public interface DriverMatchingStrategy {
    Driver matchDriver(Set<Driver> drivers, TripRequest tripRequest);
}
