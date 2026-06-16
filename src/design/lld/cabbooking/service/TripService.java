package design.lld.cabbooking.service;

import design.lld.cabbooking.entity.Driver;
import design.lld.cabbooking.entity.Trip;
import design.lld.cabbooking.entity.TripRequest;

import java.util.HashMap;
import java.util.Map;

public class TripService {
    private final DriverFindingService driverFindingService;
    private final PriceCalculationService priceCalculationService;
    private final Map<String, Trip> trips;

    public TripService(DriverFindingService driverFindingService, PriceCalculationService priceCalculationService) {
        this.driverFindingService = driverFindingService;
        this.priceCalculationService = priceCalculationService;
        this.trips = new HashMap<>();
    }

    public Trip bookTrip(TripRequest tripRequest){
        Driver matchedDriver = driverFindingService.findAndAssignDriver(tripRequest);
        double estimatedPrice = priceCalculationService.fetchEstimatedPrice(tripRequest);
        Trip newTrip = new Trip(tripRequest.getRider(), matchedDriver, tripRequest.getSource(), tripRequest.getDestination(), estimatedPrice);
        trips.put(newTrip.getTripId(), newTrip);
        return newTrip;
    }

    public Trip startTrip(Trip trip){
        trip.markTripStarted();
        return trip;
    }

    public Trip endTrip(Trip trip){
        trip.markTripEnded();
        return trip;
    }
}
