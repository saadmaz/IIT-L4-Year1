package com.juzail.ticketingsystem.service;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final TicketService ticketService;

    public CustomerService(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public void retrieveTicket() {
        // Logic to simulate customer retrieving tickets, calling ticketService.buyTicket()
    }
}
