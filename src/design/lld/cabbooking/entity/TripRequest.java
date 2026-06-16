package design.lld.cabbooking.entity;

import design.lld.cabbooking.entity.enums.CarType;
import design.lld.cabbooking.entity.enums.DriverMatchingType;

public class TripRequest {
    private final Rider rider;
    private final String source;
    private final String destination;
    private final CarType carType;
    private final DriverMatchingType driverMatchingType;

    public TripRequest(Rider rider, String source, String destination, CarType carType, DriverMatchingType driverMatchingType) {
        this.rider = rider;
        this.source = source;
        this.destination = destination;
        this.carType = carType;
        this.driverMatchingType = driverMatchingType;
    }

    public Rider getRider() {
        return rider;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public CarType getCarType() {
        return carType;
    }

    public DriverMatchingType getDriverMatchingType() {
        return driverMatchingType;
    }
}
