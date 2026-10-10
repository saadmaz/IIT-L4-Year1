package com.juzail.ticketingsystem.controller;

import com.juzail.ticketingsystem.model.Ticket;
import com.juzail.ticketingsystem.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/buyTicket")
    public Ticket buyTicket() {
        return ticketService.buyTicket(); // Call to service method for buying a ticket
    }

    @GetMapping("/getTicketsSold")
    public int getTicketsSold() {
        return ticketService.getTicketsSold();
    }

    @GetMapping("/areTicketsExhausted")
    public boolean areTicketsExhausted() {
        return ticketService.areTicketsExhausted();
    }
}
