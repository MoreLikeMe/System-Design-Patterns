package design.lld.parkinglot.service;

import design.lld.parkinglot.entity.Ticket;
import design.lld.parkinglot.entity.Vehicle;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketService {
    private final Map<Integer, Ticket> tickets;

    public TicketService(){
        this.tickets = new HashMap<>();
    }

    public Ticket getTicket(int ticketId){
        return tickets.get(ticketId);
    }

    public List<Ticket> getAllTickets(){
        return new ArrayList<>(tickets.values());
    }

    public Ticket generateTicket(Vehicle vehicle, int parkingSpotNo){

        //Generating unique ticketID
        int ticketId = 0;
        while(tickets.containsKey(ticketId)){
            ticketId = (int)(Math.random()*(1000-1+1))+1;
        }

        //Generating ticket
        Ticket ticket = new Ticket(ticketId, vehicle, LocalDateTime.now(),parkingSpotNo);
        tickets.put(ticketId, ticket);
        return ticket;
    }
}
