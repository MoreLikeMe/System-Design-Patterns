package design.lld.parkinglot.entity;

import design.lld.parkinglot.service.ParkingManager;
import design.lld.parkinglot.service.TicketService;

import java.util.Optional;

public class Entry implements Gate {
    private final int gateNo;
    private final TicketService ticketService;
    private final ParkingManager parkingManager;

    public Entry(int gateNo, TicketService ticketService, ParkingManager parkingManager) {
        this.gateNo = gateNo;
        this.ticketService = ticketService;
        this.parkingManager = parkingManager;
    }

    @Override
    public int getGateNo() {
        return gateNo;
    }

    public Ticket provideEntry(Vehicle vehicle){
        //assign available parking spot
        Optional<ParkingSpot> allotedSpot = parkingManager.checkAndAssignSpot(vehicle);

        //generate & return ticket
        return allotedSpot.map(parkingSpot -> ticketService.generateTicket(vehicle, parkingSpot.getSpotNo())).orElse(null);
    }


}
