package design.lld.cabbooking.service;

import design.lld.cabbooking.entity.TripRequest;
import design.lld.cabbooking.entity.Driver;
import design.lld.cabbooking.entity.enums.CarType;
import design.lld.cabbooking.strategy.drivermatching.DriverMatchingStrategy;
import design.lld.cabbooking.strategy.drivermatching.DriverMatchingStrategyFactory;

import java.util.*;
import java.util.stream.Collectors;

public class DriverFindingService {
    private DriverMatchingStrategy driverMatchingStrategy;
    private final Map<CarType, Set<Driver>> availableDrivers;

    public DriverFindingService() {
        this.availableDrivers = Arrays.stream(CarType.values()).collect(Collectors.toMap(
                carType -> carType,
                carType -> new HashSet<>()
        ));
    }

    public Driver findAndAssignDriver(TripRequest tripRequest){
        Set<Driver> drivers = availableDrivers.get(tripRequest.getCarType());
        driverMatchingStrategy = DriverMatchingStrategyFactory.getStrategy(tripRequest.getDriverMatchingType());
        Driver driver = driverMatchingStrategy.matchDriver(drivers, tripRequest);
        //*****handle gracefully if driver not found
        //here
        //*****handle gracefully if driver not found

        driver.markAssigned(); //Assign the driver and return
        return driver;
    }

    //*******Driver Methods*****************//
    public void addDriver(Driver driver){
        driver.markAvailable();
        availableDrivers.get(driver.getCarType()).add(driver);
    }
}
