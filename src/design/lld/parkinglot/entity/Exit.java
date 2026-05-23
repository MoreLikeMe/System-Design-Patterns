package design.lld.parkinglot.entity;

import design.lld.parkinglot.service.ParkingManager;
import design.lld.parkinglot.service.PaymentService;
import design.lld.parkinglot.service.TicketService;

public class Exit implements Gate {
    private final int gateNo;
    private final TicketService ticketService;
    private final PaymentService paymentService;
    private final ParkingManager parkingManager;


    public Exit(int gateNo, TicketService ticketService, PaymentService paymentService, ParkingManager parkingManager) {
        this.gateNo = gateNo;
        this.ticketService = ticketService;
        this.paymentService = paymentService;
        this.parkingManager = parkingManager;
    }

    @Override
    public int getGateNo() {
        return gateNo;
    }

    public void processExit(int ticketNo){
        //fetch the Ticket Details
        Ticket ticket = ticketService.getTicket(ticketNo);

        //Calculate the parking fees
        double price = paymentService.calculatePayment(ticket);
        System.out.println("Existing Vehicle: " + ticket.getVehicle());
        System.out.println("To be Paid: " + price);

        //make payment
        boolean paymentStatus = paymentService.makePayment(ticket);

        //close the ticket
        ticket.close();

        //free the parking spot
        parkingManager.releaseSpot(ticket.getParkingSpotNo());
    }
}
