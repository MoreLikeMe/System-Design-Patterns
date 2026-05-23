package design.lld.parkinglot.service;

import design.lld.parkinglot.entity.*;

import java.util.*;
import java.util.stream.Collectors;

public class ParkingManager {
    private final ParkingSpace parkingLot;
    private final TicketService ticketService;
    private final Map<Integer, ParkingSpot> spots;
    private final Map<VehicleType, Queue<Integer>> availableSpots;

    public ParkingManager(ParkingSpace parkingLot, TicketService ticketService) {
        this.parkingLot = parkingLot;
        this.ticketService = ticketService;
        this.spots = parkingLot.getFloors().stream()
                .flatMap(parkingFloor -> parkingFloor.getParkingSpots().stream())
                .collect(Collectors.toMap(
                        ParkingSpot::getSpotNo,
                        parkingSpot -> parkingSpot
                ));

        this.availableSpots = Arrays.stream(VehicleType.values())
                .collect(Collectors.toMap(
                        vehicleType -> vehicleType,
                        vehicleType -> new LinkedList<Integer>()
                ));

        this.spots.values().forEach(parkingSpot -> {
           this.availableSpots.get(parkingSpot.getVehicleAllowed()).add(parkingSpot.getSpotNo());
        });
    }

    public Optional<ParkingSpot> checkAndAssignSpot(Vehicle vehicle){
        VehicleType type = vehicle.getVehicleType();
        Queue<Integer> spotsQueue = availableSpots.get(type);
        if(!spotsQueue.isEmpty()){
            int spotNo = spotsQueue.poll();
            ParkingSpot allotedSpot = spots.get(spotNo);
            allotedSpot.occupySpot();
            return Optional.of(allotedSpot);
        }
        return Optional.empty();
    }

    public void releaseSpot(int parkingSpotNo){
        ParkingSpot spot = spots.get(parkingSpotNo);
        spot.releaseSpot();
        availableSpots.get(spot.getVehicleAllowed()).add(spot.getSpotNo());
    }

    public ParkingSpace getParkingLot() {
        return parkingLot;
    }
}
