package design.lld.cabbooking;

import design.lld.cabbooking.entity.Driver;
import design.lld.cabbooking.entity.Rider;
import design.lld.cabbooking.entity.Trip;
import design.lld.cabbooking.entity.TripRequest;
import design.lld.cabbooking.entity.enums.CarType;
import design.lld.cabbooking.entity.enums.DriverMatchingType;
import design.lld.cabbooking.service.*;

public class Main {
    public static void main(String[] args) {

        //************** Prepare the Application ****************************************//
        RiderService riderService = new RiderService();
        Rider xyz = riderService.createRider("XYZ Rider", "+91-1010101010");
        Rider pqr = riderService.createRider("PQR Rider", "+91-1010109999");

        DriverFindingService driverFindingService = new DriverFindingService();
        Driver rajesh = new Driver("Rajesh", "#1234", "KA01-5678", CarType.ECONOMY);
        Driver mukesh = new Driver("Mukesh", "#5678", "KA01-2345", CarType.PREMIUM);
        driverFindingService.addDriver(rajesh);
        driverFindingService.addDriver(mukesh);

        PriceCalculationService priceCalculationService = new PriceCalculationService();
        TripService tripService = new TripService(driverFindingService, priceCalculationService);

        ApplicationService appService = new ApplicationService(tripService, riderService);



        //************** Test the Application ******************************************//
        TripRequest tripRequest1 = new TripRequest(xyz, "Rashbehari", "Hazra", CarType.ECONOMY, DriverMatchingType.LOWEST_DISTANCE);
        Trip trip1 = tripService.bookTrip(tripRequest1);
        System.out.println(trip1);

        TripRequest tripRequest2 = new TripRequest(pqr, "Tollygunge", "Garia", CarType.PREMIUM, DriverMatchingType.LOWEST_DISTANCE);
        Trip trip2 = tripService.bookTrip(tripRequest2);
        System.out.println(trip2);

        tripService.startTrip(trip1);
        System.out.println(trip1);

        tripService.startTrip(trip2);
        System.out.println(trip2);

        tripService.endTrip(trip1);
        System.out.println(trip1);

        tripService.endTrip(trip2);
        System.out.println(trip2);


        TripRequest tripRequest3 = new TripRequest(pqr, "Garia", "Tollygunge", CarType.PREMIUM, DriverMatchingType.LOWEST_DISTANCE);
        Trip trip3 = tripService.bookTrip(tripRequest3);
        System.out.println(trip3);

        tripService.startTrip(trip3);
        System.out.println(trip3);

        tripService.endTrip(trip3);
        System.out.println(trip3);
    }
}
