package design.lld.cabbooking.service;

public class ApplicationService {
    private RiderService riderService;
    private TripService tripService;

    public ApplicationService(TripService tripService, RiderService riderService) {
        this.tripService = tripService;
        this.riderService = riderService;
    }

    public RiderService getRiderService() {
        return riderService;
    }

    public TripService getTripService() {
        return tripService;
    }
}
