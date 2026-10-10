package com.juzail.ticketingsystem.service;

import com.juzail.ticketingsystem.model.Ticket;
import com.juzail.ticketingsystem.model.TicketPool;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

    private final TicketPool ticketPool;

    public TicketService(TicketPool ticketPool) {
        this.ticketPool = ticketPool;
    }

    public synchronized Ticket buyTicket() {
        return ticketPool.buyTicket();
    }

    public synchronized void addTicket(Ticket ticket) {
        ticketPool.addTicket(ticket);
    }

    public int getTicketsSold() {
        return ticketPool.getTicketsSold();
    }

    public boolean areTicketsExhausted() {
        return ticketPool.isTicketsExhausted();
    }
}
