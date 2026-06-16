package design.lld.cabbooking.strategy.drivermatching;

import design.lld.cabbooking.entity.TripRequest;
import design.lld.cabbooking.entity.Driver;
import design.lld.cabbooking.entity.enums.DriverStatus;

import java.util.Set;

public class LowestDistanceStrategy implements DriverMatchingStrategy{

    @Override
    public Driver matchDriver(Set<Driver> drivers, TripRequest tripRequest) {
        for(Driver driver: drivers){
            if(driver.getDriverStatus().equals(DriverStatus.AVAILABLE)){
                return driver;
            }
        }
        return null;
    }
}
