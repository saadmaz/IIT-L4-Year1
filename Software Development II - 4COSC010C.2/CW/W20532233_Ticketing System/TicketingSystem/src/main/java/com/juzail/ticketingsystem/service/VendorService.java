package com.juzail.ticketingsystem.service;

import org.springframework.stereotype.Service;

@Service
public class VendorService {

    private final TicketService ticketService;

    public VendorService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public void releaseTicket() {
        // Logic to simulate vendor ticket release, calling ticketService.addTicket()
    }
}
