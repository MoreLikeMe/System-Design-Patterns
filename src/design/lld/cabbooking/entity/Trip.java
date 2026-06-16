package design.lld.cabbooking.entity;

import design.lld.cabbooking.entity.enums.TripStatus;

import java.util.UUID;

public class Trip {
    private final String tripId;
    private final Rider rider;
    private final Driver driver;
    private final String pickUpLocation;
    private final String dropLocation;
    private final double estimatedPrice;
    private TripStatus tripStatus;

    public Trip(Rider rider, Driver driver, String pickUpLocation, String dropLocation, double estimatedPrice) {
        this.tripId = UUID.randomUUID().toString();
        this.rider = rider;
        this.driver = driver;
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.estimatedPrice = estimatedPrice;
        this.tripStatus = TripStatus.CREATED;
    }

    public String getTripId() {
        return tripId;
    }

    public Driver getDriver() {
        return driver;
    }

    public void markTripStarted(){
        driver.markBusy(); //making driver busy as it is in active ride
        tripStatus = TripStatus.STARTED;
    }

    public void markTripEnded(){
        driver.markAvailable(); //making driver available again to take another trip
        tripStatus = TripStatus.ENDED;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "tripId='" + tripId + '\'' +
                ", rider=" + rider +
                ", driver=" + driver +
                ", pickUpLocation='" + pickUpLocation + '\'' +
                ", dropLocation='" + dropLocation + '\'' +
                ", estimatedPrice=" + estimatedPrice +
                ", tripStatus=" + tripStatus +
                '}';
    }
}
