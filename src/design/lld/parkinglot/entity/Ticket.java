package design.lld.parkinglot.entity;

import java.time.LocalDateTime;

public class Ticket {
    private final int ticketId;
    private final Vehicle vehicle;
    private final LocalDateTime startTime;
    private final int parkingSpotNo;
    private ParkingTicketStatus parkingTicketStatus;

    public Ticket(int ticketId, Vehicle vehicle, LocalDateTime startTime, int parkingSpotNo) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.startTime = startTime;
        this.parkingSpotNo = parkingSpotNo;
        this.parkingTicketStatus = ParkingTicketStatus.OPEN;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getParkingSpotNo() {
        return parkingSpotNo;
    }

    public ParkingTicketStatus getParkingTicketStatus() {
        return parkingTicketStatus;
    }

    public void close(){
        this.parkingTicketStatus = ParkingTicketStatus.CLOSED;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", vehicle=" + vehicle +
                ", startTime=" + startTime +
                ", parkingSpotNo=" + parkingSpotNo +
                ", parkingTicketStatus=" + parkingTicketStatus +
                '}';
    }
}
