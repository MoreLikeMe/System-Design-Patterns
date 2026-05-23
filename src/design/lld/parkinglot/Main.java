package design.lld.parkinglot;

import design.lld.parkinglot.entity.*;
import design.lld.parkinglot.service.ParkingManager;
import design.lld.parkinglot.service.PaymentService;
import design.lld.parkinglot.service.TicketService;

public class Main {
    public static void main(String[] args) {
        //Prepare the Application
        TicketService ticketService = new TicketService();
        PaymentService paymentService = new PaymentService();

        ParkingManager manager = prepareParkingManager(ticketService);

        Entry entryGate1 = new Entry(1, ticketService, manager);
        Entry entryGate2 = new Entry(2, ticketService, manager);
        Exit exitGate1 = new Exit(3, ticketService, paymentService, manager);

        manager.getParkingLot().addGate(entryGate1);
        manager.getParkingLot().addGate(entryGate2);
        manager.getParkingLot().addGate(exitGate1);

        //Parking service starts here
        Vehicle car1 = new Vehicle("HJGH6756", VehicleType.SUV);
        Ticket ticket1 = entryGate1.provideEntry(car1);
        System.out.println(ticket1);

        Vehicle car2 = new Vehicle("HJGH5466", VehicleType.SUV);
        Ticket ticket2 = entryGate1.provideEntry(car2);
        System.out.println(ticket2);

        Vehicle car3 = new Vehicle("HYGH6756", VehicleType.SUV);
        Ticket ticket3 = entryGate1.provideEntry(car3);
        System.out.println(ticket3);

        Vehicle car4 = new Vehicle("HHFRS756", VehicleType.SEDAN);
        Ticket ticket4 = entryGate1.provideEntry(car4);
        System.out.println(ticket4);

        exitGate1.processExit(ticket4.getTicketId());

        Vehicle car5 = new Vehicle("ADFH6756", VehicleType.SEDAN);
        Ticket ticket5 = entryGate1.provideEntry(car5);
        System.out.println(ticket5);

        System.out.println(ticketService.getAllTickets());

    }

    private static ParkingManager prepareParkingManager(TicketService ticketService) {
        ParkingSpot suvSpot1 = new ParkingSpot(1, VehicleType.SUV);
        ParkingSpot suvSpot2 = new ParkingSpot(2, VehicleType.SUV);
        ParkingSpot sedanSpot1 = new ParkingSpot(3, VehicleType.SEDAN);

        ParkingFloor groundFloor = new ParkingFloor(0);
        groundFloor.addSpot(suvSpot1);
        groundFloor.addSpot(suvSpot2);
        groundFloor.addSpot(sedanSpot1);

        ParkingSpace parkingLot = new ParkingSpace(1);
        parkingLot.addFloor(groundFloor);

        ParkingManager manager = new ParkingManager(parkingLot, ticketService);
        return manager;
    }
}
